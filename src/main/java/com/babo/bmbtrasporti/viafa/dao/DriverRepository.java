package com.babo.bmbtrasporti.viafa.dao;

import com.babo.bmbtrasporti.viafa.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {
}
