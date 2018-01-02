package com.jbr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jbr.domain.DeviceCondition;
import com.jbr.entity.DeviceEntity;

public interface DeviceMapper {

	List<DeviceEntity> getAll();

	List<DeviceEntity> getByBind(@Param("bind") int bind, @Param("limit") int limit);

	List<Long> getIdByBind(@Param("bind") int bind, @Param("limit") int limit);

	DeviceEntity getOne(Long id);

	void insert(DeviceEntity device);

	void insertBatch(List<DeviceEntity> list);

	void updateCount(List<DeviceEntity> list);

	void delete(Long id);

	void updateFirstLoginTime(Long id);

	int getCount(DeviceCondition condition);

	List<DeviceEntity> getByLimit(DeviceCondition condition);

	void initCount();

}
