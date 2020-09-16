package com.babo.bmbtrasporti.viafa.service;

import com.babo.bmbtrasporti.viafa.dao.TruckDAO;
import com.babo.bmbtrasporti.viafa.entity.Truck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TruckServiceImpl implements TruckService {

    @Autowired
    private TruckDAO truckDAO;

    @Override
    @Transactional
    public List<Truck> findAll() {
        return truckDAO.findAll();
    }

    @Override
    @Transactional
    public Truck findById(int id) {
        return truckDAO.findById(id);
    }

    @Override
    @Transactional
    public void save(Truck truck) {
        truckDAO.save(truck);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        truckDAO.deleteById(id);
    }
}
