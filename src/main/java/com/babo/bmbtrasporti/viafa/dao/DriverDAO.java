package com.babo.bmbtrasporti.viafa.dao;

import com.babo.bmbtrasporti.viafa.entity.Driver;

import java.util.List;

public interface DriverDAO {

    List<Driver> findAll();

    Driver findById(int id);

    void save(Driver driver);

    void deleteById(int id);

}
