package com.ga.wonderwater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ga.wonderwater.dao.WaterBodyDao;
import com.ga.wonderwater.model.WaterBody;

@RestController
public class WaterBodyController {
	
	@Autowired
	WaterBodyDao waterBodyDao;

	@GetMapping("/waterbody/index")
	public Iterable<WaterBody> getWaterBodies(){
		var it = waterBodyDao.findAll();
		return it;
	}
	
	@GetMapping("/waterbody/details")
	public WaterBody waterBodyDetails(@RequestParam int id) {
		WaterBody waterBody = waterBodyDao.findById(id);
		return waterBody;
	}
	
	@PostMapping("/waterbody/add")
	public WaterBody addWaterBody(@RequestBody WaterBody waterBody) {
		waterBodyDao.save(waterBody);
		return waterBody;
	}
	
	@PutMapping("/waterbody/edit")
	public WaterBody editWaterBody(@RequestBody WaterBody waterBody) {
		waterBodyDao.save(waterBody);
		return waterBody;
	}
	
	@DeleteMapping("/waterbody/delete")
	public boolean deleteWaterBody(@RequestParam int id) {
		waterBodyDao.deleteById(id);
		return true;
	}
	
}
