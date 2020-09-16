package com.babo.bmbtrasporti.viafa.rest;

import com.babo.bmbtrasporti.viafa.entity.Truck;
import com.babo.bmbtrasporti.viafa.service.TruckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class TruckRestController {

    @Autowired
    private TruckService truckService;

    @GetMapping("/trucks")
    public List<Truck> findAll() {
        return truckService.findAll();
    }

    @GetMapping("/trucks/{truckId}")
    public Truck findById(@PathVariable int truckId) {
        Truck truck = truckService.findById(truckId);

        if (truck == null) {
            throw new RuntimeException("Truck id not found - " + truckId);
        }

        return truck;
    }

    @PostMapping("/trucks")
    public Truck addTruck(@RequestBody Truck truck) {
        truck.setId(0);

        truckService.save(truck);

        return truck;
    }

    @PutMapping("/trucks")
    public Truck updateTruck(@RequestBody Truck truck) {
        truckService.save(truck);

        return truck;
    }

    @DeleteMapping("/trucks/{truckId}")
    public String deleteTruck(@PathVariable int truckId) {
        Truck truck = truckService.findById(truckId);

        if (truck == null) {
            throw new RuntimeException("Truck id not found - " + truckId);
        }

        truckService.deleteById(truckId);

        return "Deleted truck id - " + truckId;
    }
}
