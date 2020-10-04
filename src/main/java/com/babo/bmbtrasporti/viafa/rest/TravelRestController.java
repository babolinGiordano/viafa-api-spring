package com.babo.bmbtrasporti.viafa.rest;

import com.babo.bmbtrasporti.viafa.entity.Client;
import com.babo.bmbtrasporti.viafa.entity.Driver;
import com.babo.bmbtrasporti.viafa.entity.Travel;
import com.babo.bmbtrasporti.viafa.entity.Truck;
import com.babo.bmbtrasporti.viafa.exception.ApiNotFoundException;
import com.babo.bmbtrasporti.viafa.service.ClientService;
import com.babo.bmbtrasporti.viafa.service.DriverService;
import com.babo.bmbtrasporti.viafa.service.TravelService;
import com.babo.bmbtrasporti.viafa.service.TruckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class TravelRestController {

    @Autowired
    private TravelService travelService;
    
    @Autowired
    private DriverService driverService;
    
    @Autowired
    private ClientService clientService;
    
    @Autowired
    private TruckService truckService;

    @GetMapping("/travels")
    public List<Travel> findAll() {
        return travelService.findAll();
    }

    @GetMapping("/travels/{travelId}")
    public Travel findById(@PathVariable int travelId) {

        return travelService.findById(travelId);
    }

    @PostMapping("/travels")
    public Travel addTravel(@RequestBody Travel travel) {
        
        Driver driver = driverService.findById(travel.getDriver().getId());
        if (driver == null) {
            throw new ApiNotFoundException("Driver id not found - " + travel.getDriver().getId());
        }
        
        Client client = clientService.findById(travel.getClient().getId());
        if (client == null) {
            throw new ApiNotFoundException("Client id not found - " + travel.getClient().getId());
        }
        
        Truck truck = truckService.findById(travel.getTruck().getId());
        if (truck == null) {
            throw new ApiNotFoundException("Truck id not found - " + travel.getTruck().getId());
        }

        travel.setId(0);
        travel.setDriver(driver);
        travel.setClient(client);
        travel.setTruck(truck);

        travelService.save(travel);

        return travel;
    }

    @PutMapping("/travels")
    public Travel updateTravel(@RequestBody Travel travel) {
        travelService.save(travel);

        return travel;
    }

    @DeleteMapping("/travels/{travelId}")
    public String deleteTravel(@PathVariable int travelId) {
        Travel travel = travelService.findById(travelId);

        if (travel == null) {
            throw new ApiNotFoundException("Travel id not found - " + travelId);
        }

        travelService.deleteById(travelId);

        return "Deleted travel id - " + travelId;
    }
}
