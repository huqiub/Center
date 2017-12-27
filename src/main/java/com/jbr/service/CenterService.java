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
		DeviceResult result = restTemplate.getForObject(url, DeviceResult.class, count, band);
		saveDevice(band, result);
	}

	public TaskEntity getTask() {
		TaskEntity task = taskMapper.getLimitOne();
		if (task != null) {
			int result = taskMapper.updateStatus(task.getId());
			if (result == 1) {
				return task;
			} else {
				return getTask();
			}
		}
		return task;
	}

	public int updateExecuteResult(String taskId, int result, String ip) {

		TaskEntity task = new TaskEntity();
		task.setId(taskId);
		task.setResultTime(new Date());
		task.setIp(ip);
		if (result == Constants.TASK_RESULT_SUCCESS) {
			task.setStatus(Constants.TASK_STATUS_SUCCESS);
		} else {
			task.setStatus(Constants.TASK_STATUS_FAIL);
		}
		return taskMapper.updateResult(task);
	}

	private void saveDevice(int band, DeviceResult result) {
		if (Constants.DEVICE_RESULT_SUCCESS == result.getCode()) {
			List<DeviceDomain> data = result.getData();
			List<DeviceEntity> list = new ArrayList<DeviceEntity>();
			for (DeviceDomain deviceDomain : data) {
				DeviceEntity device = new DeviceEntity();
				device.setId(deviceDomain.getId());
				device.setBinding(band);
				device.setChannalId(deviceDomain.getChannalId());
				list.add(device);
			}
			deviceMapper.insertBatch(list);
		}
	}

}
