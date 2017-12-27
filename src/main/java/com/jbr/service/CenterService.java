package com.jbr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jbr.constant.Constants;
import com.jbr.domain.DeviceDomain;
import com.jbr.domain.DeviceResult;
import com.jbr.entity.DeviceEntity;
import com.jbr.mapper.DeviceMapper;

@Service
public class CenterService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private DeviceMapper deviceMapper;

	@Value("${get.device.url}")
	private String url;

	public void getDeviceAndSave(int count, int band) {
		DeviceResult result = restTemplate.getForObject(url, DeviceResult.class, count, band);
		saveDevice(band, result);
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
