package com.jbr.mapper;

import java.util.List;

import com.jbr.entity.DeviceEntity;

public interface DeviceMapper {

	List<DeviceEntity> getAll();

	DeviceEntity getOne(Long id);

	void insert(DeviceEntity device);

	void insertBatch(List<DeviceEntity> list);

	void update(Long id);

	void delete(Long id);
}
