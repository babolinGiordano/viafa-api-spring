package com.babo.bmbtrasporti.viafa.service;

import com.babo.bmbtrasporti.viafa.dao.TruckRepository;
import com.babo.bmbtrasporti.viafa.entity.Truck;
import com.babo.bmbtrasporti.viafa.exception.ApiNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TruckServiceImpl implements TruckService {

    @Autowired
    private TruckRepository truckRepository;

    @Override
    public List<Truck> findAll() {
        return truckRepository.findAll();
    }

    @Override
    public Truck findById(int id) {
        Optional<Truck> trucks = truckRepository.findById(id);

        Truck truck;
        if (trucks.isPresent()) {
            truck = trucks.get();
        } else {
            throw new ApiNotFoundException("Truck id not found - " + id);
        }

        return truck;
    }

    @Override
    public void save(Truck truck) {
        truckRepository.save(truck);
    }

    @Override
    public void deleteById(int id) {
        truckRepository.deleteById(id);
    }
}
