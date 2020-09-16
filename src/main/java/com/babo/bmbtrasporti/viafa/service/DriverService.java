package com.babo.bmbtrasporti.viafa.service;

import com.babo.bmbtrasporti.viafa.entity.Driver;

import java.util.List;

public interface DriverService {

    List<Driver> findAll();

    Driver findById(int id);

    void save(Driver driver);

    void deleteById(int id);

}
