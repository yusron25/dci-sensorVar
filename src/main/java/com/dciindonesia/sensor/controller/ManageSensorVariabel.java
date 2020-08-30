package com.dciindonesia.sensor.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dciindonesia.sensor.entity.MasterSensor;
import com.dciindonesia.sensor.model.Response;
import com.dciindonesia.sensor.service.MasterSensorService;

@RestController
@CrossOrigin
public class ManageSensorVariabel {

	@Autowired
	private MasterSensorService services;
	
	
	@GetMapping("/")
	public Response<MasterSensor> findAllVar(){
		Response resp = new Response();
		resp.setSuccess(true);
		resp.setMessage("success");
		resp.setData(services.getVars());
		return resp;
	}
	
	@GetMapping("/detail/{id}")
	public MasterSensor findVar(@PathVariable String id) {
		return services.getVar(id);
	}
	
	@PostMapping("/")
	public MasterSensor addVar(@ModelAttribute MasterSensor varx) {
		return services.saveVar(varx);
	}
	
	@PostMapping("/detail/{id}")
	public MasterSensor updateVar(@ModelAttribute MasterSensor varx) {
		return services.update(varx);
	}
	
	@GetMapping("/delete/{id}")
	public void deleteVar(@PathVariable int id) {
		services.deleteVar(id);
	}
	
	@PostMapping("/deletes")
	public void deleteVars(@RequestParam(value="id[]") List<Integer> ids) {
//		return ids;
		
		 services.deleteVars(ids);
	}
	
	
}
