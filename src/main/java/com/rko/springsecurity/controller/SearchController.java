package com.rko.springsecurity.controller;

import com.rko.springsecurity.dto.SearchResultDTO;
import com.rko.springsecurity.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

/*

    @GetMapping("/search")
    public ResponseEntity<SearchResultDTO> search(@PathVariable Long drugId, Long locationId) {
        SearchResultDTO result = searchService.searchDrugIdByLocationId(drugId, locationId);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }
*/


}