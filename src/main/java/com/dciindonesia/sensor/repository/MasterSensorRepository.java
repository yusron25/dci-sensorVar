package com.dciindonesia.sensor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dciindonesia.sensor.entity.MasterSensor;

public interface MasterSensorRepository extends JpaRepository<MasterSensor, Integer>{
	MasterSensor findByvarId(String varId);
}
