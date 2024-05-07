package com.rko.springsecurity.controller;

import com.rko.springsecurity.dto.SearchResultDTO;
import com.rko.springsecurity.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private SearchService searchService;

    @GetMapping
    public ResponseEntity<SearchResultDTO> search(
            @RequestParam("brandName") String brandName,
            @RequestParam("locationName") String locationName) {
        SearchResultDTO result = searchService.searchBrandNameByLocation(brandName, locationName);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

}
