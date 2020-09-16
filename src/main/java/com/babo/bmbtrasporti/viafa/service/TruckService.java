package com.babo.bmbtrasporti.viafa.service;

import com.babo.bmbtrasporti.viafa.entity.Truck;

import java.util.List;

public interface TruckService {

    List<Truck> findAll();

    Truck findById(int id);

    void save(Truck truck);

    void deleteById(int id);

}
