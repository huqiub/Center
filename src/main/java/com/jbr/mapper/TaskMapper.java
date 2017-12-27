package com.jbr.mapper;

import java.util.List;

import com.jbr.entity.TaskEntity;

public interface TaskMapper {

	List<TaskEntity> getAll();

	TaskEntity getOne(String id);

	TaskEntity getLimitOne();

	void insert(TaskEntity task);

	void insertBatch(List<TaskEntity> list);

	void update(TaskEntity task);

	int updateStatus(String id);

	int updateResult(TaskEntity task);

	void delete(Long id);
}
