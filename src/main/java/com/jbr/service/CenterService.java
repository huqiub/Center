package com.jbr.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jbr.constant.Constants;
import com.jbr.domain.DeviceDomain;
import com.jbr.domain.DeviceResult;
import com.jbr.entity.DeviceEntity;
import com.jbr.entity.TaskEntity;
import com.jbr.exception.ServiceException;
import com.jbr.mapper.DeviceMapper;
import com.jbr.mapper.TaskMapper;

@Service
public class CenterService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private DeviceMapper deviceMapper;

	@Autowired
	private TaskMapper taskMapper;

	@Value("${get.device.url}")
	private String url;

	public void getDeviceAndSave(int count, int band) {
		DeviceResult result = null;
		try {
			result = restTemplate.getForObject(url, DeviceResult.class, count, band);
		} catch (Exception e) {
			throw new ServiceException("restTemplate获取设备时出错：" + e.getMessage());
		}
		if (result != null) {
			saveDevice(band, result);
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

	private void saveDevice(int band, DeviceResult result) {
		try {
			if (Constants.DEVICE_RESULT_SUCCESS == result.getCode()) {
				List<DeviceDomain> data = result.getData();
				List<DeviceEntity> list = new ArrayList<DeviceEntity>();
				for (DeviceDomain deviceDomain : data) {
					DeviceEntity device = new DeviceEntity();
					device.setId(deviceDomain.getId());
					device.setBinding(band);
					device.setChannalId(deviceDomain.getChannalId());
					device.setImei(deviceDomain.getImei());
					device.setImsi(deviceDomain.getImsi());
					device.setSerailNo(deviceDomain.getSerailNo());
					device.setPhoneNo(deviceDomain.getPhoneNo());
					list.add(device);
				}
				deviceMapper.insertBatch(list);
			}
		} catch (Exception e) {
			throw new ServiceException("批量插入设备时出错：" + e.getMessage());
		}
	}

}
