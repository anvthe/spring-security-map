package com.rko.springsecurity.service;

import com.rko.springsecurity.domain.Location;
import com.rko.springsecurity.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public Location getLocationByName(String locationName){
        Optional<Location> optionalLocation = locationRepository.findByLocationName(locationName);
        return optionalLocation.orElse(null);
    }
}
