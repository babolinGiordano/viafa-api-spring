package com.babo.bmbtrasporti.viafa.rest;

import java.util.List;

import com.babo.bmbtrasporti.viafa.exception.ApiNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.babo.bmbtrasporti.viafa.entity.Driver;
import com.babo.bmbtrasporti.viafa.service.DriverService;

@Slf4j
@RestController
@RequestMapping("/api")
public class DriverRestController {

    @Autowired
    private DriverService driverService;

    @GetMapping("/drivers")
    public List<Driver> findAll() {
        return driverService.findAll();
    }

    @GetMapping("/drivers/{driverId}")
    public Driver findById(@PathVariable int driverId) {

        return driverService.findById(driverId);
    }

    @PostMapping("/drivers")
    public Driver addEmployee(@RequestBody Driver driver) {

        driver.setId(0);

        driverService.save(driver);

        return driver;
    }

    @PutMapping("/drivers")
    public Driver updateEmployee(@RequestBody Driver driver) {

        driverService.save(driver);

        return driver;
    }

    @DeleteMapping("/drivers/{driverId}")
    public String deleteEmployee(@PathVariable int driverId) {

        Driver driver = driverService.findById(driverId);

        if (driver == null) {
            throw new ApiNotFoundException("Driver id not found - " + driverId);
        }

        driverService.deleteById(driverId);

        return "Deleted employee id - " + driverId;
    }

}
