package com.ga.wonderwater.dao;

import org.springframework.data.repository.CrudRepository;

import com.ga.wonderwater.model.WaterBody;

public interface WaterBodyDao extends CrudRepository<WaterBody, Integer>{
	public WaterBody findById(int id);
}
