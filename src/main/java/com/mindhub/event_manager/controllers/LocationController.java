package com.mindhub.event_manager.controllers;

import com.mindhub.event_manager.dtos.event.EventDetailDTO;
import com.mindhub.event_manager.dtos.location.LocationDetailDTO;
import com.mindhub.event_manager.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/location")
public class LocationController {
    @Autowired
    private LocationRepository locationRepository;

    @GetMapping
    public ResponseEntity<List<LocationDetailDTO>> getLocations(){
        return new ResponseEntity<>(locationRepository.findAll().stream().map(LocationDetailDTO::new).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{locationId}")
    public ResponseEntity<LocationDetailDTO> getEventById(@PathVariable UUID locationId){
        return new ResponseEntity<>(locationRepository.findById(locationId).map(LocationDetailDTO::new).orElseThrow(()->new RuntimeException()),HttpStatus.OK);
    }

}
