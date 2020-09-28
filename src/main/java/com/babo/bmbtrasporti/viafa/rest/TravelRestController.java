package com.babo.bmbtrasporti.viafa.rest;

import com.babo.bmbtrasporti.viafa.entity.Travel;
import com.babo.bmbtrasporti.viafa.exception.ApiNotFoundException;
import com.babo.bmbtrasporti.viafa.service.TravelService;
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

    @GetMapping("/travels")
    public List<Travel> findAll() {
        return travelService.findAll();
    }

    @GetMapping("/travels/{travelId}")
    public Travel findById(@PathVariable int travelId) {
        Travel travel = travelService.findById(travelId);

        if (travel == null) {
            throw new ApiNotFoundException("Travel id not found - " + travelId);
        }

        return travel;
    }

    @PostMapping("/travels")
    public Travel addTravel(@RequestBody Travel travel) {

        travel.setId(0);

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
