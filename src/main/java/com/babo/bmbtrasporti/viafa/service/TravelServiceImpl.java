package com.babo.bmbtrasporti.viafa.service;

import com.babo.bmbtrasporti.viafa.dao.TravelRepository;
import com.babo.bmbtrasporti.viafa.entity.Travel;
import com.babo.bmbtrasporti.viafa.exception.ApiNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TravelServiceImpl implements TravelService{

    @Autowired
    private TravelRepository travelRepository;

    @Override
    public List<Travel> findAll() {
        return travelRepository.findAll();
    }

    @Override
    public Travel findById(int id) {
        Optional<Travel> travels = travelRepository.findById(id);

        Travel travel;
        if(travels.isPresent()){
            travel = travels.get();
        } else {
            throw new ApiNotFoundException("Travel id not found - " + id);
        }

        return travel;
    }

    @Override
    public void save(Travel travel) {
        travelRepository.save(travel);
    }

    @Override
    public void deleteById(int id) {
        travelRepository.deleteById(id);
    }
}
