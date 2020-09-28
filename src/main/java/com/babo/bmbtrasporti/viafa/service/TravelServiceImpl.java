package com.babo.bmbtrasporti.viafa.service;

import com.babo.bmbtrasporti.viafa.dao.TravelDAO;
import com.babo.bmbtrasporti.viafa.entity.Travel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TravelServiceImpl implements TravelService{

    @Autowired
    private TravelDAO travelDAO;

    @Override
    @Transactional
    public List<Travel> findAll() {
        return travelDAO.findAll();
    }

    @Override
    @Transactional
    public Travel findById(int id) {
        return travelDAO.findById(id);
    }

    @Override
    @Transactional
    public void save(Travel travel) {
        travelDAO.save(travel);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        travelDAO.deleteById(id);
    }
}
