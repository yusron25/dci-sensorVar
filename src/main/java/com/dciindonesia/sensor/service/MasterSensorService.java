package com.dciindonesia.sensor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dciindonesia.sensor.entity.MasterSensor;
import com.dciindonesia.sensor.model.Response;
import com.dciindonesia.sensor.repository.MasterSensorRepository;

@Service
public class MasterSensorService {

	@Autowired
	private MasterSensorRepository repo;
	
	public List<MasterSensor> getVars() {
		return repo.findAll();
	}
	
	public MasterSensor getIdSensor(int id) {
		return repo.findById(id).orElse(null);
	}
	
	public MasterSensor getVar(String varId) {
		return repo.findByvarId(varId);
	}
	
	public MasterSensor saveVar(MasterSensor data) {
		return repo.save(data);
	}
	
	public MasterSensor update(MasterSensor data) {
		MasterSensor existing = repo.findById(data.getId()).orElse(null);
		existing.setVarId(data.getVarId());
		existing.setVarName(data.getVarName());
		existing.setLocation(data.getLocation());
		existing.setCategory(data.getCategory());
		existing.setId(data.getId());
		return repo.save(existing);
	}
	
	public void deleteVar(int data) {

		MasterSensor isData  = repo.findById(data).orElse(null);
		repo.delete(isData);
	}
	
	public void deleteVars(List<Integer> id) {
		Response<MasterSensor> res =  new Response();
		try {
			List<MasterSensor> target = null;
			for (Integer idx : id) {
//				int i = Integer.parseInt(idx.trim());
				repo.deleteById(idx);
			}
			res.setSuccess(true);
			res.setData(null);
			res.setMessage("success");
		}catch(Exception e) {
			res.setSuccess(false);
			res.setData(null);
			res.setMessage(e.getMessage());
		}
//		return res;
		
	}
	
	
}
