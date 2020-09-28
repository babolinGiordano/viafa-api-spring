package com.babo.bmbtrasporti.viafa.dao;

import com.babo.bmbtrasporti.viafa.entity.Travel;

import java.util.List;

public interface TravelDAO {

    List<Travel> findAll();

    Travel findById(int id);

    void save(Travel travel);

    void deleteById(int id);
}
