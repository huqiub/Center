package com.jbr.service;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.util.StringUtils;

import com.jbr.constant.Constants;
import com.jbr.domain.Children;
import com.jbr.domain.DeviceCondition;
import com.jbr.domain.DeviceDomain;
import com.jbr.domain.DeviceInferModel;
import com.jbr.domain.DeviceResult;
import com.jbr.domain.Rule;
import com.jbr.domain.Task;
import com.jbr.domain.TaskCondition;
import com.jbr.domain.TreeModel;
import com.jbr.entity.DeviceEntity;
import com.jbr.entity.RuleEntity;
import com.jbr.entity.ScriptEntity;
import com.jbr.entity.TaskEntity;
import com.jbr.exception.ServiceException;
import com.jbr.mapper.DeviceMapper;
import com.jbr.mapper.RuleMapper;
import com.jbr.mapper.ScriptMapper;
import com.jbr.mapper.TaskMapper;
import com.jbr.util.FileUtils;
import com.jbr.util.ScriptUtils;
import com.jbr.util.ServiceUtils;
import com.jbr.util.Utils;

@Service
public class CenterService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private AsyncUpdateDeviceService asyncTask;

	@Autowired
	private DeviceMapper deviceMapper;

	@Autowired
	private TaskMapper taskMapper;

	@Autowired
	private RuleMapper ruleMapper;

	@Autowired
	private ScriptMapper scriptMapper;

	@Value("${get.device.url}")
	private String url;

	@Value("${root.tree.info}")
	private String rootTreeInfo;

	@Value("${admin.tree.info}")
	private String adminTreeInfo;

	@Value("${script.download.url}")
	private String downloadUrl;

	@Value("${batch.limit}")
	private int batchLimit;

	@Value("${script.location}")
	private String scriptLocation;

	@Value("${script.new.location}")
	private String scriptNewLocation;

	@Value("${touchelf.scripts.location}")
	private String touchelfScriptsLocation;

	@Value("${touchelf.encrypt.scripts.location}")
	private String touchelfEncryptScriptsLocation;

	@Value("${adb.path}")
	private String adbPath;

	@Value("${noLogin}")
	private float noLogin;

	@Value("${activelyDays7}")
	private float activelyDays7;

	@Value("${abTime}")
	private float abTime;

	@Value("${real.count.per}")
	private float realCountPer;

	public TreeModel getTree(String user) {
		TreeModel tree = new TreeModel();
		List<Children> list = new ArrayList<Children>();
		String treeInfo = adminTreeInfo;
		if ("root".equals(user)) {
			treeInfo = rootTreeInfo;
		}
		if (!StringUtils.isEmpty(treeInfo)) {
			String[] arr = treeInfo.split(",");
			for (int i = 0; i < arr.length; i++) {
				list.add(setChildren(arr[i]));
			}
		}
		tree.setText("菜单");
		tree.setChildren(list);
		return tree;
	}

	private Children setChildren(String value) {
		Children c1 = new Children();
		if (!StringUtils.isEmpty(value)) {
			String[] arr = value.split(":");
			c1.setText(arr[0]);
			Map<String, String> map = new HashMap<>();
			map.put("url", arr[1]);
			c1.setAttributes(map);
		}
		return c1;
	}

	public List<Task> searchTasks(TaskCondition condition) {

		List<TaskEntity> list = taskMapper.getByLimit(condition);
		List<Task> taskList = new ArrayList<Task>();
		if (!Utils.isEmptyList(list)) {
			for (TaskEntity entity : list) {
				Task task = new Task();
				BeanUtils.copyProperties(entity, task);
				taskList.add(task);
			}
		}
		return taskList;
	}

	public int searchTasksCount(TaskCondition condition) {
		try {
			return taskMapper.getCount(condition);
		} catch (Exception e) {
			throw new ServiceException("restTemplate获取设备时出错：" + e.getMessage());
		}
	}

	public void getDeviceAndSave(int count, int bind) {
		DeviceResult result = null;
		try {
			result = restTemplate.getForObject(url, DeviceResult.class, count, bind);
		} catch (Exception e) {
			throw new ServiceException("restTemplate获取设备时出错：" + e.getMessage());
		}
		if (result != null) {
			saveDevice(bind, result);
		}
	}

	public TaskEntity getTask() {
		TaskEntity task = null;
		try {
			task = taskMapper.getLimitOne();
			if (task != null) {
				int result = taskMapper.updateStatus(task.getId());
				if (result == 1) {
					return task;
				} else {
					return getTask();
				}
			}
		} catch (Exception e) {
			throw new ServiceException("获取任务时出错：" + e.getMessage());
		}
		return task;
	}

	public int updateExecuteResult(String taskId, int result, String ip) {
		int count = 0;
		try {
			TaskEntity task = new TaskEntity();
			task.setId(taskId);
			task.setResultTime(new Date());
			task.setIp(ip);
			if (result == Constants.TASK_RESULT_SUCCESS) {
				task.setStatus(Constants.TASK_STATUS_SUCCESS);
			} else {
				task.setStatus(Constants.TASK_STATUS_FAIL);
			}
			count = taskMapper.updateResult(task);
		} catch (Exception e) {
			throw new ServiceException("更新任务状态时出错：" + e.getMessage());
		}
		return count;
	}

	private void saveDevice(int bind, DeviceResult result) {
		try {
			if (Constants.DEVICE_RESULT_SUCCESS == result.getCode()) {
				List<DeviceDomain> data = result.getData();
				List<DeviceEntity> list = new ArrayList<DeviceEntity>();
				for (DeviceDomain deviceDomain : data) {
					DeviceEntity device = new DeviceEntity();
					device.setId(deviceDomain.getId());
					device.setBind(bind);
					device.setChannalId(deviceDomain.getChannalId());
					device.setImei(deviceDomain.getImei());
					device.setImsi(deviceDomain.getImsi());
					device.setSerialNo(deviceDomain.getSerialno());
					device.setPhoneNo(deviceDomain.getPhoneno());
					if (ServiceUtils.validImei(deviceDomain.getImei())
							&& ServiceUtils.validImsi(deviceDomain.getImsi())) {
						device.setValid(Constants.DEVICE_VALID);
					} else {
						device.setValid(Constants.DEVICE_INVALID);
					}
					list.add(device);
				}
				deviceMapper.insertBatch(list);
			}
		} catch (Exception e) {
			throw new ServiceException("批量插入设备时出错：" + e.getMessage());
		}
	}

	public void insertOrUpdateRule(Rule rule) {
		RuleEntity ruleEntity = ruleMapper.getOne(rule.getMonth(), rule.getChannel());
		if (ruleEntity != null) {
			rule.setAbTime(ruleEntity.getAbTime());
			rule.setActivelyDays7(ruleEntity.getActivelyDays7());
			rule.setNoLogin(ruleEntity.getNoLogin());
		} else {
			ruleEntity = new RuleEntity();
			rule.setAbTime(abTime);
			rule.setActivelyDays7(activelyDays7);
			rule.setNoLogin(noLogin);
		}
		BeanUtils.copyProperties(rule, ruleEntity);
		try {
			ruleMapper.insert(ruleEntity);
		} catch (Exception e) {
			throw new ServiceException("新增或者更新规则数据时出错：" + e.getMessage());
		}
	}

	public Rule loadRule(String month, String channel) {
		Rule rule = new Rule();
		try {
			RuleEntity ruleEntity = ruleMapper.getOne(month, channel);
			if (ruleEntity != null) {
				BeanUtils.copyProperties(ruleEntity, rule);
			}
		} catch (Exception e) {
			throw new ServiceException("过去规则数据时出错：" + e.getMessage());
		}
		return rule;
	}

	public void distributeTask(Rule rule) {
		int realT000 = randomRealCount(rule.getT000());
		int realT001 = randomRealCount(rule.getT001());
		int realT010 = randomRealCount(rule.getT010());
		int realT011 = randomRealCount(rule.getT011());

		int realT100 = randomRealCount(rule.getT100());
		int realT101 = randomRealCount(rule.getT101());
		int realT110 = randomRealCount(rule.getT110());
		int realT111 = randomRealCount(rule.getT111());

		int isBindCount = realT100 + realT101 + realT110 + realT111;
		int notBindCount = realT000 + realT001 + realT010 + realT011;
		List<Long> bindList = deviceMapper.getIdByBind(Constants.DEVICE_BIND, isBindCount);
		List<Long> notBindList = deviceMapper.getIdByBind(Constants.DEVICE_NOT_BIND, notBindCount);

		// 在执行前天确保设备表数据足够，需先校验。
		if (!ServiceUtils.checkDeviceIsEnough(isBindCount, notBindCount, bindList.size(), notBindList.size())) {
			throw new ServiceException("设备数不能满足这次任务量，请先获取设备");
		}

		List<Long> list100 = bindList.subList(0, realT100);

		List<Long> list101 = bindList.subList(realT100, realT100 + realT101);
		List<Long> list110 = bindList.subList(realT100 + realT101, realT100 + realT101 + realT110);
		List<Long> list111 = bindList.subList(realT100 + realT101 + realT110, isBindCount);

		List<Long> list000 = notBindList.subList(0, realT000);
		List<Long> list001 = notBindList.subList(realT000, realT000 + realT001);
		List<Long> list010 = notBindList.subList(realT000 + realT001, realT000 + realT001 + realT010);
		List<Long> list011 = notBindList.subList(realT000 + realT001 + realT010, notBindCount);

		List<TaskEntity> taskList = new ArrayList<>();
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		disTask(taskList, map, rule.getMonth(), list000, 0, 0, 0);
		disTask(taskList, map, rule.getMonth(), list001, 0, 0, 1);
		disTask(taskList, map, rule.getMonth(), list010, 0, 1, 0);
		disTask(taskList, map, rule.getMonth(), list011, 0, 1, 1);
		disTask(taskList, map, rule.getMonth(), list100, 1, 0, 0);
		disTask(taskList, map, rule.getMonth(), list101, 1, 0, 1);
		disTask(taskList, map, rule.getMonth(), list110, 1, 1, 0);
		disTask(taskList, map, rule.getMonth(), list111, 1, 1, 1);

		batchInsertTask(taskList);
		asyncTask.setMap(map);
		asyncTask.start();
	}

	private void batchInsertTask(List<TaskEntity> taskList) {
		int size = taskList.size();
		int count = size / batchLimit;
		int remainder = size % batchLimit;
		for (int i = 1; i <= count; i++) {
			int index = batchLimit * (i - 1);
			int offset = batchLimit * i;
			taskMapper.insertBatch(taskList.subList(index, offset));
		}
		if (remainder != 0) {
			taskMapper.insertBatch(taskList.subList(batchLimit * count, size));
		}
	}

	// 有效开始时间：1.时间段分布;2.同一个设备登陆的天数;3.同一个设备，每天登陆次数;
	private void disTask(List<TaskEntity> taskList, Map<Long, Integer> map, String month, List<Long> idList,
			int isLogin, int activelyDays7, int abTime) {
		try {
			List<DeviceInferModel> baseList = new ArrayList<DeviceInferModel>();
			List<DeviceInferModel> inferActivelyList = new ArrayList<DeviceInferModel>();
			List<DeviceInferModel> additionalList = new ArrayList<DeviceInferModel>();

			inferTask(idList, activelyDays7, baseList, inferActivelyList, additionalList);

			List<Integer> baseTimeList = new ArrayList<Integer>();
			List<Integer> additionalTimeList = new ArrayList<Integer>();
			ServiceUtils.inferTimeQuantum(baseList.size(), baseTimeList, abTime, true);

			ServiceUtils.inferTimeQuantum(additionalList.size(), additionalTimeList, abTime, false);

			insertTasks(taskList, map, month, isLogin, baseList, baseTimeList, true);
			insertTasks(taskList, map, month, isLogin, inferActivelyList, null, false);
			insertTasks(taskList, map, month, isLogin, additionalList, additionalTimeList, false);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("分配任务出错：" + e.getMessage());
		}
	}

	private void insertTasks(List<TaskEntity> taskList, Map<Long, Integer> map, String month, int isLogin,
			List<DeviceInferModel> inferList, List<Integer> list, boolean isBaseTasks) {
		for (DeviceInferModel inferModer : inferList) {
			TaskEntity task = new TaskEntity();
			task.setId(ServiceUtils.getTaskId());
			task.setDeviceId(inferModer.getDeviceId());
			task.setStatus(Constants.TASK_STATUS_NEW);

			task.setOperation(ServiceUtils.getOperation(isLogin));
			task.setScriptId(ServiceUtils.getScriptId(isLogin));// 随机获取脚本
			task.setDownloadUrl(downloadUrl + task.getScriptId());
			if (isBaseTasks) {
				task.setValidTime(ServiceUtils.getValidTime(month, inferModer.getDay(), list));
			} else {
				task.setValidTime(ServiceUtils.getValidTimeByRandom(month, inferModer.getDay()));
			}
			task.setInvalidTime(ServiceUtils.getInvalidTime(task.getValidTime()));
			Integer deviceCount = map.get(task.getDeviceId());
			if (deviceCount == null) {
				map.put(task.getDeviceId(), 1);
			} else {
				map.put(task.getDeviceId(), deviceCount + 1);
			}
			taskList.add(task);
		}
	}

	// 有效开始时间：1.时间段分布;2.同一个设备登陆的天数;3.同一个设备，每天登陆次数;
	private void inferTask(List<Long> idList, int activelyDays7, List<DeviceInferModel> baseList,
			List<DeviceInferModel> inferActivelyList, List<DeviceInferModel> additionalList) {
		for (Long id : idList) {
			int firstDay = Utils.randomInt(1, 30);
			DeviceInferModel inferModel = new DeviceInferModel();
			inferModel.setDeviceId(id);
			inferModel.setDay(firstDay);
			// inferModel.setActivelyDays7(activelyDays7);
			baseList.add(inferModel);
			int day = firstDay + 6;
			if (activelyDays7 == Constants.ACTIVELY_DAYS7) {// 如果是7日留存，则先在第一次操作后的第7天在进行操作。
				DeviceInferModel model = new DeviceInferModel();
				model.setDeviceId(id);
				model.setDay(day);
				inferActivelyList.add(model);
			}

			// 1-7天内执行次数
			inferOtherDay(additionalList, id, firstDay);
			// 1-7外执行次数
			inferOtherDay(additionalList, id, day);

		}
	}

	private void inferOtherDay(List<DeviceInferModel> additionalList, Long id, int firstDay) {
		int monthLoginCount = Utils.randomInt(0, 3);
		int dayLoginCount = Utils.randomInt(0, 2);
		// 1-7天内执行次数
		for (int i = 0; i < monthLoginCount; i++) {
			firstDay += Utils.randomInt(1, 2);
			for (int j = 0; j < dayLoginCount; j++) {
				DeviceInferModel model = new DeviceInferModel();
				model.setDeviceId(id);
				model.setDay(firstDay);
				additionalList.add(model);
			}
		}
	}

	public void updateDeviceFirstLoginTime(long deviceId) {
		try {
			deviceMapper.updateFirstLoginTime(deviceId);
		} catch (Exception e) {
			throw new ServiceException("更新设备表第一次操作时间出错：" + e.getMessage());
		}
	}

	public void generateScript() {
		try {
			List<ScriptEntity> list = new ArrayList<ScriptEntity>();
			Integer maxId = scriptMapper.getMaxId();
			if (maxId == null) {
				maxId = 0;
			}
			ScriptUtils.operation(scriptLocation + "mould", list, maxId + 1);
			if (list.size() > 0) {
				scriptMapper.insertBatch(list);
			}
		} catch (Exception e) {
			throw new ServiceException("插入脚本表出错：" + e.getMessage());
		}

	}

	public void pushScript() {
		try {
			List<String> commands = new ArrayList<String>();
			commands.add("cd " + adbPath);
			File file = new File(scriptNewLocation);
			if (file.exists()) {
				File[] fileArr = file.listFiles();
				for (int i = 0; i < fileArr.length; i++) {
					String command = "adb push " + fileArr[i].getPath() + " " + touchelfScriptsLocation;
					commands.add(command);
				}
			}
			commands.add("pause");
			commands.add("exit\n");
			String path = scriptLocation + "push.bat";
			FileUtils.writeToFile(path, commands);
			ServiceUtils.execCommand(path);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("复制电脑里的文件到设备时出错：" + e.getMessage());
		}

	}

	public void pullScript() {
		try {
			List<String> commands = new ArrayList<String>();
			commands.add("cd " + adbPath);
			File file = new File(scriptNewLocation);
			if (file.exists()) {
				String[] fileArr = file.list();
				for (int i = 0; i < fileArr.length; i++) {
					String command = "adb pull " + touchelfEncryptScriptsLocation + fileArr[i] + ".E3" + " "
							+ scriptLocation;
					commands.add(command);
				}
			}
			commands.add("pause");
			commands.add("exit\n");
			String path = scriptLocation + "pull.bat";
			FileUtils.writeToFile(path, commands);
			ServiceUtils.execCommand(path);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("复制设备里的文件到电脑时出错：" + e.getMessage());
		}

	}

	public void compute(Rule rule) {
		RuleEntity entity = ruleMapper.getOne(rule.getMonth(), rule.getChannel());
		if (entity != null) {
			noLogin = entity.getNoLogin();// m1
			activelyDays7 = entity.getActivelyDays7();// m2
			abTime = entity.getAbTime();// m3
		}

		int t000 = rule.getT000();// m11 t000
		int t001 = rule.getT001();// m10 t001
		int t010 = rule.getT010();// m9 t010
		int t011 = rule.getT011();// m8 t011

		int t100 = rule.getT100();// m7 t100
		int t101 = rule.getT101();// m6 t101
		int t110 = rule.getT110();// m5 t110
		int t111 = rule.getT111();// m4 t111

		int n4 = 0;
		int n5 = 0;
		int n6 = 0;
		int n7 = 0;
		int n8 = 0;
		int n9 = 0;
		int n10 = 0;
		int n11 = 0;

		int t4 = 0;
		int t5 = 0;
		int t6 = 0;
		int t7 = 0;
		int t8 = 0;
		int t9 = 0;
		int t10 = 0;
		int t11 = 0;

		int w4 = 0;
		int w5 = 0;
		int w6 = 0;
		int w7 = 0;
		int w8 = 0;
		int w9 = 0;
		int w10 = 0;
		int w11 = 0;

		int noUserTotal = t000 + t001 + t010 + t011;
		int hasUserTotal = t100 + t101 + t110 + t111;

		int total = noUserTotal + hasUserTotal;

		if (((float) noUserTotal / total) > noLogin) {
			int needReject = (int) Math.ceil(noUserTotal - (total * noLogin));
			int needRejectAgain = needReject - t000;
			if (needRejectAgain >= 0) {
				int needRejectAgain2 = needRejectAgain - t001;
				if (needRejectAgain2 >= 0) {
					int needRejectAgain3 = needRejectAgain2 - t010;
					if (needRejectAgain3 >= 0) {
						int needRejectAgain4 = needRejectAgain3 - t011;
						if (needRejectAgain4 >= 0) {
							n4 = t111;
							n5 = t110;
							n6 = t101;
							n7 = t100;
						} else {
							n8 = t011 - needRejectAgain3;
							n4 = t111;
							n5 = t110;
							n6 = t101;
							n7 = t100;
						}
					} else {
						n9 = t010 - needRejectAgain2;
						n4 = t111;
						n5 = t110;
						n6 = t101;
						n7 = t100;
						n8 = t011;
					}
				} else {

					n10 = t001 - needRejectAgain;
					n4 = t111;
					n5 = t110;
					n6 = t101;
					n7 = t100;
					n8 = t011;
					n9 = t010;
				}
			} else {

				n11 = t000 - needReject;
				n4 = t111;
				n5 = t110;
				n6 = t101;
				n7 = t100;
				n8 = t011;
				n9 = t010;
				n10 = t001;
			}

		} else {
			n4 = t111;
			n5 = t110;
			n6 = t101;
			n7 = t100;
			n8 = t011;
			n9 = t010;
			n10 = t001;
			n11 = t000;
		}

		int isDayTotal = n4 + n5 + n8 + n9;
		int noDayTotal = n6 + n7 + n10 + n11;
		int total1 = isDayTotal + noDayTotal;
		if (activelyDays7 > (float) isDayTotal / total1) {
			int needReject = (int) Math.ceil((noDayTotal - (total1 * (1 - activelyDays7))) / activelyDays7);
			int needRejectAgain = needReject - n11;
			if (needRejectAgain >= 0) {
				int needRejectAgain2 = needRejectAgain - n7;
				if (needRejectAgain2 >= 0) {
					int needRejectAgain3 = needRejectAgain2 - n10;
					if (needRejectAgain3 >= 0) {
						int needRejectAgain4 = needRejectAgain3 - n6;
						if (needRejectAgain4 >= 0) {
							t4 = n4;
							t5 = n5;
							t8 = n8;
							t9 = n9;
						} else {
							t6 = n6 - needRejectAgain3;
							t4 = n4;
							t5 = n5;
							t8 = n8;
							t9 = n9;
						}
					} else {
						t10 = n10 - needRejectAgain2;
						t4 = n4;
						t5 = n5;
						t6 = n6;
						t8 = n8;
						t9 = n9;
					}
				} else {
					t7 = n7 - needRejectAgain;
					t4 = n4;
					t5 = n5;
					t6 = n6;
					t8 = n8;
					t9 = n9;
					t10 = n10;
				}
			} else {
				t11 = n11 - needReject;
				t4 = n4;
				t5 = n5;
				t6 = n6;
				t7 = n7;
				t8 = n8;
				t9 = n9;
				t10 = n10;
			}
		} else {
			t4 = n4;
			t5 = n5;
			t6 = n6;
			t7 = n7;
			t8 = n8;
			t9 = n9;
			t10 = n10;
			t11 = n11;
		}

		int abTimeTotal = t5 + t7 + t9 + t11;
		int isTimeTotal = t4 + t6 + t8 + t10;
		int total2 = abTimeTotal + isTimeTotal;
		if (((float) abTimeTotal / total2) > abTime) {
			int needReject = (int) Math.ceil(abTimeTotal - (total2 * abTime));
			int needRejectAgain = needReject - t11;
			if (needRejectAgain >= 0) {
				int needRejectAgain2 = needRejectAgain - t9;
				if (needRejectAgain2 >= 0) {
					int needRejectAgain3 = needRejectAgain2 - t7;
					if (needRejectAgain3 >= 0) {
						int needRejectAgain4 = needRejectAgain3 - t5;
						if (needRejectAgain4 >= 0) {
							w4 = t4;
							w6 = t6;
							w8 = t8;
							w10 = t10;
						} else {
							w5 = t5 - needRejectAgain3;
							w4 = t4;
							w6 = t6;
							w8 = t8;
							w10 = t10;
						}
					} else {
						w7 = t7 - needRejectAgain2;
						w4 = t4;
						w5 = t5;
						w6 = t6;
						w8 = t8;
						w10 = t10;
					}
				} else {
					w9 = t9 - needRejectAgain;
					w4 = t4;
					w5 = t5;
					w6 = t6;
					w7 = t7;
					w8 = t8;
					w10 = t10;
				}
			} else {
				w11 = t11 - needReject;
				w4 = t4;
				w5 = t5;
				w6 = t6;
				w7 = t7;
				w8 = t8;
				w9 = t9;
				w10 = t10;
			}
		} else {
			w4 = t4;
			w5 = t5;
			w6 = t6;
			w7 = t7;
			w8 = t8;
			w9 = t9;
			w10 = t10;
			w11 = t11;
		}

		rule.setR000(format(w11, t000, true));
		rule.setR001(format(w10, t001, true));
		rule.setR010(format(w9, t010, true));
		rule.setR011(format(w8, t011, true));

		rule.setR100(format(w7, t100, true));
		rule.setR101(format(w6, t101, true));
		rule.setR110(format(w5, t110, true));
		rule.setR111(format(w4, t111, true));

		rule.setS000(format(t000, total, false));
		rule.setS001(format(t001, total, false));
		rule.setS010(format(t010, total, false));
		rule.setS011(format(t011, total, false));

		rule.setS100(format(t100, total, false));
		rule.setS101(format(t101, total, false));
		rule.setS110(format(t110, total, false));
		rule.setS111(format(t111, total, false));
		rule.setAllSum(rule.getAllSum());
		rule.setValidSum(rule.getValidSum());

	}

	private String format(int a, int b, boolean isSub) {
		DecimalFormat df = new DecimalFormat("0.00");
		if (isSub) {
			return df.format((1 - (float) a / b) * 100) + "%";

		} else {
			return df.format(((float) a / b) * 100) + "%";
		}
	}

	public List<DeviceEntity> searchDevice(DeviceCondition condition) {
		try {
			return deviceMapper.getByLimit(condition);
		} catch (Exception e) {
			throw new ServiceException("按条件查询设备时出错：" + e.getMessage());
		}
	}

	public int searchDeviceCount(DeviceCondition condition) {
		try {
			return deviceMapper.getCount(condition);
		} catch (Exception e) {
			throw new ServiceException("按条件查询设备数量时出错：" + e.getMessage());
		}
	}

	private int randomRealCount(int count) {
		return Utils.randomInt((int) (count - count * realCountPer), (int) (count + count * realCountPer));
	}

	public int truncateTask() {
		try {
			return taskMapper.truncateTable();
		} catch (Exception e) {
			throw new ServiceException("truncateTask时出错：" + e.getMessage());
		}

	}

	public void initCount() {
		try {
			deviceMapper.initCount();
		} catch (Exception e) {
			throw new ServiceException("初始化设备表使用次数为0时出错：" + e.getMessage());
		}

	}
}
