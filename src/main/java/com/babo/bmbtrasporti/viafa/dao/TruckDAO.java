package com.babo.bmbtrasporti.viafa.dao;

import com.babo.bmbtrasporti.viafa.entity.Truck;

import java.util.List;

public interface TruckDAO {

    List<Truck> findAll();

    Truck findById(int id);

    void save(Truck truck);

    void deleteById(int id);
}
