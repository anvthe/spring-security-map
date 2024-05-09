package com.rko.springsecurity.service;

import com.rko.springsecurity.domain.Location;
import com.rko.springsecurity.dto.SearchResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SearchService {
    @Autowired
    private DrugService drugService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private PrescriptionService prescriptionService;

        public SearchResultDTO searchDrugNameByLocationName(String drugName, String locationName){
            SearchResultDTO result = new SearchResultDTO();
            String drug = drugService.getDrugByName(drugName);
            if (drug == null) {
                result.setError("Drug not found");
                return result;
            }

            Location location = locationService.getLocationByName(locationName);
            if (location == null) {
                result.setError("Location not found");
                return result;
            }

            int drugUsersCount = prescriptionService.countUsersByDrugNameAndLocationName(drugName, locationName);

            result.setBrandUsersCount(drugUsersCount);
            result.setLocation(location);
            result.setDrugName(drug);
            return result;
        }




/*    public SearchResultDTO searchDrugIdByLocationId(Long drugId, Long locationId){
        SearchResultDTO result = new SearchResultDTO();
        Long drug = drugService.getDrugById(drugId);
        if (drug == null) {
            result.setError("Brand not found");
            return result;
        }

        Long location = locationService.getLocationById(locationId);
        if (location == null) {
            result.setError("Location not found");
            return result;
        }

        int drugUsersCount = prescriptionService.countUsersByDrugIdAndLocationId(drugId, locationId);

        result.setBrandUsersCount(drugUsersCount);
        result.setLocation(locationId)
        return result;
    }*/


    }
