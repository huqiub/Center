package com.jbr;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jbr.constant.Constants;
import com.jbr.entity.TaskEntity;
import com.jbr.mapper.TaskMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControlCenter1ApplicationTests {

	@Autowired
	// private DeviceMapper deviceMapper;
	private TaskMapper taskMapper;

	@Test
	public void test() throws Exception {

		// List<DeviceEntity> list = new ArrayList<DeviceEntity>();
		// DeviceEntity d1 = new DeviceEntity();
		// d1.setId(Long.valueOf(123114566));
		// d1.setBinding(12);
		// d1.setChannalId("12334422");
		// list.add(d1);
		// DeviceEntity d2 = new DeviceEntity();
		// d2.setId(Long.valueOf(123453366));
		// d2.setBinding(12);
		// d2.setChannalId("12334422");
		// list.add(d2);
		// // d1.setCreateTime(new Date(System.currentTimeMillis()));
		// // d1.setFirstLoginTime(new Date(System.currentTimeMillis() +
		// // 24357348));
		// // deviceMapper.insert(d1);
		// deviceMapper.insertBatch(list);
		// // deviceRepository.save(d1);

		// 测试findAll, 查询所有记录

		TaskEntity t1 = new TaskEntity();
		t1.setId("201712271111");
		// t1.setDeviceId(Long.valueOf(123114566));
		// t1.setDownloadUrl("http://localhost:8080/task/test.lua");
		// t1.setScriptId(2);
		// t1.setOperation(1);
		// t1.setValidTime(Utils.stringToDate("2017/12/27 16:17:00",
		// "yyyy/MM/dd hh:mm:ss"));
		// t1.setInvalidTime(Utils.stringToDate("2017/12/27 16:30:00",
		// "yyyy/MM/dd hh:mm:ss"));
		t1.setResultTime(new Date());
		t1.setIp("192.168.1.110");
		t1.setStatus(Constants.TASK_STATUS_SUCCESS);
		// taskMapper.insert(t1);
		// Assert.assertEquals(1, taskMapper.getAll().size());

		taskMapper.updateResult(t1);
		TaskEntity t2 = taskMapper.getOne(t1.getId());
		Assert.assertEquals(2, t2.getStatus());

	}
}
