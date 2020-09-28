package com.babo.bmbtrasporti.viafa.service;


import com.babo.bmbtrasporti.viafa.entity.Travel;

import java.util.List;

public interface TravelService {

    List<Travel> findAll();

    Travel findById(int id);

    void save(Travel travel);

    void deleteById(int id);
}
