package com.rko.springsecurity.service;

import com.rko.springsecurity.domain.Location;
import com.rko.springsecurity.dto.SearchResultDTO;
import com.rko.springsecurity.repository.PrescriptionRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class SearchService {
    @Autowired
    private BrandService brandService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private PrescriptionService prescriptionService;

    @Autowired
    private PrescriptionRepository prescriptionRepository;


    public SearchResultDTO searchBrandNameByLocation(String brandName, String locationName) {

        SearchResultDTO result = new SearchResultDTO();

        String brand = brandService.getBrandByName(brandName);
        if (brand == null) {
            result.setError("Brand not found");
            return result;
        }


        Location location = locationService.getLocationByName(locationName);
        if (location == null) {
            result.setError("Location not found");
            return result;
        }


        int brandUsersCount = prescriptionService.countUsersByBrandAndLocation(brandName, locationName);

        result.setBrandUsersCount(brandUsersCount);
        result.setLocation(location);
        return result;
    }
}
