package com.jbr.mapper;

import java.util.List;

import com.jbr.entity.ScriptEntity;

public interface ScriptMapper {

	List<ScriptEntity> getAll();

	ScriptEntity getOne(Integer id);

	List<Integer> getIdList(int type);

	void insert(ScriptEntity device);

	void insertBatch(List<ScriptEntity> list);

	Integer getMaxId();
}
