package com.jbr;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jbr.entity.DeviceEntity;
import com.jbr.mapper.DeviceMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControlCenter1ApplicationTests {

	@Autowired
	private DeviceMapper deviceMapper;

	@Test
	public void test() throws Exception {

		List<DeviceEntity> list = new ArrayList<DeviceEntity>();
		DeviceEntity d1 = new DeviceEntity();
		d1.setId(Long.valueOf(123114566));
		d1.setBinding(12);
		d1.setChannalId("12334422");
		list.add(d1);
		DeviceEntity d2 = new DeviceEntity();
		d2.setId(Long.valueOf(123453366));
		d2.setBinding(12);
		d2.setChannalId("12334422");
		list.add(d2);
		// d1.setCreateTime(new Date(System.currentTimeMillis()));
		// d1.setFirstLoginTime(new Date(System.currentTimeMillis() +
		// 24357348));
		// deviceMapper.insert(d1);
		deviceMapper.insertBatch(list);
		// deviceRepository.save(d1);

		// 测试findAll, 查询所有记录
		Assert.assertEquals(4, deviceMapper.getAll().size());

	}
}
