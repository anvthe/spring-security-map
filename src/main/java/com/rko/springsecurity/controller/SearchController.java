package com.rko.springsecurity.controller;

import com.rko.springsecurity.domain.Drug;
import com.rko.springsecurity.domain.Location;
import com.rko.springsecurity.dto.SearchResultDTO;
import com.rko.springsecurity.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private SearchService searchService;

    @GetMapping()
    public ResponseEntity<SearchResultDTO> search(
            @RequestParam("drugName") String drugName,
            @RequestParam("locationName") String locationName) {
        SearchResultDTO result = searchService.searchDrugNameByLocationName(drugName, locationName);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }


    @GetMapping("/id")
    public ResponseEntity<SearchResultDTO> search(@RequestParam Long drugId, @RequestParam Long locationId) {
        SearchResultDTO result = searchService.searchByDrugIdAndLocationId(drugId, locationId);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/drugs")
    public List<Drug> getAllDrugs() {
        return searchService.getAllDrugs();

    }

    @GetMapping("/locations")
    public List<Location> getAllLocations() {
        return searchService.getAllLocations();

    }

}