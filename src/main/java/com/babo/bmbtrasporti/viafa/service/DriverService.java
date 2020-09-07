package com.babo.bmbtrasporti.viafa.service;

import java.util.List;

import com.babo.bmbtrasporti.viafa.entity.Driver;


public interface DriverService {
	
	public List<Driver> findAll();

	public Driver findById(int id);

	public void save(Driver employee);

	public void deleteById(int id);

}
