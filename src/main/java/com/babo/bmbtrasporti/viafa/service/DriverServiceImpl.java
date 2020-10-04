package com.babo.bmbtrasporti.viafa.service;

import java.util.List;
import java.util.Optional;

import com.babo.bmbtrasporti.viafa.dao.DriverRepository;
import com.babo.bmbtrasporti.viafa.exception.ApiNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babo.bmbtrasporti.viafa.entity.Driver;

@Service
public class DriverServiceImpl implements DriverService {
	
	@Autowired
	private DriverRepository driverRepository;

	@Override
	public List<Driver> findAll() {
		return driverRepository.findAll();
	}

	@Override
	public Driver findById(int id) {
		Optional<Driver> drivers = driverRepository.findById(id);

		Driver driver;
		if(drivers.isPresent()){
			driver = drivers.get();
		} else {
			throw new ApiNotFoundException("Driver id not found - " + id);
		}

		return driver;
	}

	@Override
	public void save(Driver driver) {
		driverRepository.save(driver);
	}

	@Override
	public void deleteById(int id) {
		driverRepository.deleteById(id);
	}

}
