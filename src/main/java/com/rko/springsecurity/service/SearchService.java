package com.rko.springsecurity.service;

import com.rko.springsecurity.domain.Drug;
import com.rko.springsecurity.domain.Location;
import com.rko.springsecurity.domain.Prescription;
import com.rko.springsecurity.dto.SearchResultDTO;
import com.rko.springsecurity.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SearchService {
    @Autowired
    private DrugService drugService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private PrescriptionService prescriptionService;
    @Autowired
    private PrescriptionRepository prescriptionRepository;

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




    public SearchResultDTO searchByDrugIdAndLocationId(Long drugId, Long locationId) {
        SearchResultDTO result = new SearchResultDTO();

        // Check if drug with the given ID exists
        Drug drug = drugService.getDrugById(drugId);
        if (drug == null) {
            result.setError("Brand not found");
            return result;
        }


        Location location = locationService.getLocationById(locationId);
        if (location == null) {
            result.setError("Location not found");
            return result;
        }


        int drugUsersCount = prescriptionService.countUsersByDrugIdAndLocationId(drugId, locationId);



        //List<Prescription> prescriptions = prescriptionRepository.findByDrugIdAndLocationId(drugId, locationId);


        //result.setBrandUsersCount(prescriptions.size());
        result.setBrandUsersCount(drugUsersCount);
        result.setDrugName(drug.getDrugName());
        result.setLocation(location);

        return result;
    }






    public List<Drug> getAllDrugs() {
        return drugService.getAllDrugs();
    }

    public List<Location> getAllLocations() {
        return locationService.getAllLocations();
    }
}
