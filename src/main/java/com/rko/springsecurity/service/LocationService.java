package com.rko.springsecurity.service;

import com.rko.springsecurity.domain.Location;
import com.rko.springsecurity.dto.LocationDTO;
import com.rko.springsecurity.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public Location getLocationByName(String name){
        Optional<Location> optionalLocation = locationRepository.findByName(name);
        return optionalLocation.orElse(null);
    }

    public Location getLocationById(Long locationId) {
        Optional<Location> optionalLocation = locationRepository.findById(locationId);
        return optionalLocation.orElse(null);
    }


    public List<LocationDTO> getAllLocations() {
        return locationRepository.findAll()
                .stream()
                .map(location -> new LocationDTO(location.getName(),location.getLatitude(),location.getLatitude()))
                .toList();
    }

}