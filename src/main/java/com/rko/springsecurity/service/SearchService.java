package com.rko.springsecurity.service;

import com.rko.springsecurity.domain.Drug;
import com.rko.springsecurity.domain.Location;
import com.rko.springsecurity.dto.DrugDTO;
import com.rko.springsecurity.dto.LocationDTO;
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

    public SearchResultDTO searchDrugNameByLocationName(String locationName, String drugName){
            SearchResultDTO result = new SearchResultDTO();

            Location location = locationService.getLocationByName(locationName);
            if (location == null) {
                result.setError("Location not found");
                return result;
            }

            String drug = drugService.getDrugByName(drugName);
            if (drug == null) {
            result.setError("Drug not found");
            return result;
            }

            int drugUsersCount = prescriptionService.countUsersByDrugNameAndLocationName(locationName, drugName);

            result.setDrugUsersCount(drugUsersCount);
            result.setLocation(location);
            result.setDrugName(drug);
            return result;
        }




    public SearchResultDTO searchByDrugIdAndLocationId(Long locationId, Long drugId) {
        SearchResultDTO result = new SearchResultDTO();

        Location location = locationService.getLocationById(locationId);
        if (location == null) {
            result.setError("Location not found");
            return result;
        }

        // Check if drug with the given ID exists
        Drug drug = drugService.getDrugById(drugId);
        if (drug == null) {
            result.setError("Brand not found");
            return result;
        }




        int drugUsersCount = prescriptionService.countUsersByDrugIdAndLocationId(locationId, drugId);



        //List<Prescription> prescriptions = prescriptionRepository.findByDrugIdAndLocationId(drugId, locationId);


        //result.setBrandUsersCount(prescriptions.size());
        result.setDrugUsersCount(drugUsersCount);
        result.setDrugName(drug.getName());
        result.setLocation(location);

        return result;
    }






    public List<DrugDTO> getAllDrugs() {
        return drugService.getAllDrugs();
    }

    public List<LocationDTO> getAllLocations() {
        return locationService.getAllLocations();
    }
}
