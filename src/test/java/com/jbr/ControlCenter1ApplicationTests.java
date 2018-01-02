package com.jbr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.jbr.domain.Children;
import com.jbr.domain.TreeModel;
import com.jbr.mapper.DeviceMapper;
import com.jbr.mapper.ScriptMapper;
import com.jbr.mapper.TaskMapper;
import com.jbr.service.CenterService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControlCenter1ApplicationTests {

	@Autowired
	private DeviceMapper deviceMapper;

	@Autowired
	private TaskMapper taskMapper;

	@Autowired
	private ScriptMapper scriptMapper;

	@Autowired
	private CenterService service;

	@Autowired
	private RestTemplate restTemplate;

	@Test
	public void test() throws Exception {

		TreeModel tree = new TreeModel();
		List<Children> list = new ArrayList<Children>();
		Children children = new Children();
		children.setText("规划计算");

		Map<String, String> map = new HashMap<>();
		map.put("url", "/getDeviceIndex");
		children.setAttributes(map);
		list.add(children);
		tree.setText("菜单");
		tree.setChildren(list);
		System.out.println(JSON.toJSONString(tree));

		// String result =
		// restTemplate.getForObject("http://localhost:8080/task/get",
		// String.class);
		// System.out.println(result);
		// List<DeviceEntity> list = new ArrayList<DeviceEntity>();
		// DeviceEntity d1 = new DeviceEntity();
		// d1.setId(Long.valueOf(1212));
		// d1.setBind(12);
		// d1.setChannalId("12334422");
		// d1.setImei("12345678901234");
		// d1.setImsi("460343243424");
		// d1.setPhoneNo("124488555");
		// list.add(d1);
		// DeviceEntity d2 = new DeviceEntity();
		// d2.setId(Long.valueOf(123453366));
		// d2.setBind(12);
		// d2.setChannalId("12334422");
		// d2.setChannalId("12334422");
		// d2.setImei("12345678901234");
		// d2.setImsi("460343243424");
		// d2.setPhoneNo("124488555");
		// list.add(d2);
		// // // d1.setCreateTime(new Date(System.currentTimeMillis()));
		// // // d1.setFirstLoginTime(new Date(System.currentTimeMillis() +
		// // // 24357348));
		// deviceMapper.insert(d2);
		// deviceMapper.insertBatch(list);
		// Assert.assertEquals(8, deviceMapper.getAll().size());

		// 测试findAll, 查询所有记录

		// TaskEntity t1 = new TaskEntity();
		// t1.setId("201712271111");
		// t1.setDeviceId(Long.valueOf(123114566));
		// t1.setDownloadUrl("http://gkitty.ddns.net:13838/task/download/1");
		// t1.setScriptId(1);
		// t1.setOperation(1);
		// t1.setValidTime(Utils.stringToDate("2018/1/2 16:17:00", "yyyy/MM/dd
		// hh:mm:ss"));
		// t1.setInvalidTime(Utils.stringToDate("2018/1/27 16:30:00",
		// "yyyy/MM/dd HH:mm:ss"));
		// // t1.setResultTime(new Date());
		// // t1.setIp("192.168.1.110");
		// // t1.setStatus(Constants.TASK_STATUS_SUCCESS);
		// taskMapper.insert(t1);
		// // Assert.assertEquals(1, taskMapper.getAll().size());
		//
		// // taskMapper.updateResult(t1);
		// TaskEntity t2 = taskMapper.getOne(t1.getId());
		// Assert.assertEquals(0, t2.getStatus());

		// List<Integer> list = scriptMapper.getIdList(2);
		// List<Integer> list = ScriptUtils.getLoginIdList();
		// Assert.assertEquals(1, list.size());
		// ServiceUtils.inferTimeQuantum(205, new
		// LinkedBlockingQueue<Integer>(), 0);

	}
}
