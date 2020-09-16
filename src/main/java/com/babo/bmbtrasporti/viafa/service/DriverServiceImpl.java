package com.babo.bmbtrasporti.viafa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.babo.bmbtrasporti.viafa.dao.DriverDAO;
import com.babo.bmbtrasporti.viafa.entity.Driver;

@Service
public class DriverServiceImpl implements DriverService {
	
	@Autowired
	private DriverDAO driverDAO;

	@Override
	@Transactional
	public List<Driver> findAll() {
		return driverDAO.findAll();
	}

	@Override
	@Transactional
	public Driver findById(int id) {
		return driverDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Driver driver) {
		driverDAO.save(driver);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		driverDAO.deleteById(id);
	}

}
