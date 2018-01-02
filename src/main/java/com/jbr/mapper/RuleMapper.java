package com.jbr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jbr.entity.RuleEntity;

public interface RuleMapper {

	List<RuleEntity> getAll();

	RuleEntity getOne(@Param("month") String month, @Param("channel") String channel);

	void insert(RuleEntity rule);

}
