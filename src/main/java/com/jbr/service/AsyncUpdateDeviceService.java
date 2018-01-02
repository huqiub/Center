package com.jbr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.jbr.entity.DeviceEntity;
import com.jbr.mapper.DeviceMapper;

@Component
public class AsyncUpdateDeviceService {

	private Map<Long, Integer> map;

	@Autowired
	private DeviceMapper deviceMapper;

	@Value("${batch.limit}")
	private int batchLimit;

	@Async("processExecutor")
	public void start() {
		updateDeviceCount(map);
	}

	private void updateDeviceCount(Map<Long, Integer> map) {
		List<DeviceEntity> updateList = new ArrayList<DeviceEntity>();
		for (Map.Entry<Long, Integer> entry : map.entrySet()) {
			DeviceEntity device = new DeviceEntity();
			device.setId(entry.getKey());
			device.setCount(entry.getValue());
			updateList.add(device);
		}

		int size = updateList.size();
		int count = size / batchLimit;
		int remainder = size % batchLimit;
		for (int i = 1; i <= count; i++) {
			int index = batchLimit * (i - 1);
			int offset = batchLimit * i;
			deviceMapper.updateCount(updateList.subList(index, offset));
		}
		if (remainder != 0) {
			deviceMapper.updateCount(updateList.subList(batchLimit * count, size));
		}

	}

	public Map<Long, Integer> getMap() {
		return map;
	}

	public void setMap(Map<Long, Integer> map) {
		this.map = map;
	}
}
