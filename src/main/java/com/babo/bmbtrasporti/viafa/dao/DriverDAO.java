package com.babo.bmbtrasporti.viafa.dao;

import java.util.List;

import com.babo.bmbtrasporti.viafa.entity.Driver;

public interface DriverDAO {

	public List<Driver> findAll();

	public Driver findById(int id);

	public void save(Driver employee);

	public void deleteById(int id);

}
