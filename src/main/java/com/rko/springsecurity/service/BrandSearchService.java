package com.rko.springsecurity.service;

import com.rko.springsecurity.domain.Brand;
import com.rko.springsecurity.domain.Location;
import com.rko.springsecurity.dto.BrandSearchDTO;
import com.rko.springsecurity.repository.BrandRepository;
import com.rko.springsecurity.repository.LocationRepository;
import com.rko.springsecurity.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BrandSearchService {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    public BrandSearchDTO searchBrandInLocation(String brandName, String locationName) {
        BrandSearchDTO resultDTO = new BrandSearchDTO();

        Optional<Location> locationOptional = locationRepository.findByLocationName(locationName);
        if (locationOptional.isEmpty()) {
            resultDTO.setError("Location not found");
            return resultDTO;
        }

        Optional<Brand> brandOptional = brandRepository.findByBrandName(brandName);
        if (brandOptional.isEmpty()) {
            resultDTO.setError("Brand not found");
            return resultDTO;
        }

        Location location = locationOptional.get();
        Brand brand = brandOptional.get();

        int brandCount = prescriptionRepository.getBrandCount(brandName, locationName);

        if (brandCount == 0) {
            resultDTO.setError("No prescriptions found for the specified brand in the specified location");
            return resultDTO;
        }

        resultDTO.setBrandName(brand.getBrandName());
        resultDTO.setBrandCount(brandCount);
        resultDTO.setLocationName(location.getLocationName());
        resultDTO.setLatitude(location.getLatitude());
        resultDTO.setLongitude(location.getLongitude());
        return resultDTO;
    }
}