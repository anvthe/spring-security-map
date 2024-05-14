package com.rko.springsecurity.controller;

import com.rko.springsecurity.dto.DrugDTO;
import com.rko.springsecurity.dto.LocationDTO;
import com.rko.springsecurity.dto.SearchResultDTO;
import com.rko.springsecurity.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/map")
public class SearchController {
    @Autowired
    private SearchService searchService;

    @GetMapping()
    public ResponseEntity<SearchResultDTO> search(
            @RequestParam("locationName") String locationName,
            @RequestParam("drugName") String drugName) {
        SearchResultDTO result = searchService.searchDrugNameByLocationName(locationName, drugName);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }


    @GetMapping("/id")
    public ResponseEntity<SearchResultDTO> search(@RequestParam Long locationId, @RequestParam Long drugId) {
        SearchResultDTO result = searchService.searchByDrugIdAndLocationId(locationId, drugId);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/drugs")
    public List<DrugDTO> getAllDrugs() {
        return searchService.getAllDrugs();

    }

    @GetMapping("/locations")
    public List<LocationDTO> getAllLocations() {
        return searchService.getAllLocations();

    }

}