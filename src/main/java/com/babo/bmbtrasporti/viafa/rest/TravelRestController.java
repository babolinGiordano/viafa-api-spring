package com.babo.bmbtrasporti.viafa.rest;

import com.babo.bmbtrasporti.viafa.dao.ClientRepository;
import com.babo.bmbtrasporti.viafa.dao.DriverRepository;
import com.babo.bmbtrasporti.viafa.dao.TruckRepository;
import com.babo.bmbtrasporti.viafa.entity.Client;
import com.babo.bmbtrasporti.viafa.entity.Driver;
import com.babo.bmbtrasporti.viafa.entity.Travel;
import com.babo.bmbtrasporti.viafa.entity.Truck;
import com.babo.bmbtrasporti.viafa.exception.ApiNotFoundException;
import com.babo.bmbtrasporti.viafa.service.TravelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class TravelRestController {

    @Autowired
    private TravelService travelService;
    
    @Autowired
    private DriverRepository driverRepository;
    
    @Autowired
    private ClientRepository clientRepository;
    
    @Autowired
    private TruckRepository truckRepository;

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
        
        Optional<Driver> driver = driverRepository.findById(travel.getDriver().getId());
        if(!driver.isPresent()){
            throw new ApiNotFoundException("Driver id not found - " + travel.getDriver().getId());
        }

        Optional<Client> client = clientRepository.findById(travel.getClient().getId());
        if (!client.isPresent()) {
            throw new ApiNotFoundException("Client id not found - " + travel.getClient().getId());
        }

        Optional<Truck> truck = truckRepository.findById(travel.getTruck().getId());
        if (!truck.isPresent()) {
            throw new ApiNotFoundException("Truck id not found - " + travel.getTruck().getId());
        }

        travel.setId(0);
        travel.setDriver(driver.get());
        travel.setClient(client.get());
        travel.setTruck(truck.get());

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
