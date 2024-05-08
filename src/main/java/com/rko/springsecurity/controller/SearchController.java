package com.rko.springsecurity.controller;

import com.rko.springsecurity.dto.BrandSearchDTO;
import com.rko.springsecurity.service.BrandSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private BrandSearchService brandSearchService;

    @GetMapping
    public BrandSearchDTO searchBrandInLocation( @RequestParam String brandName, @RequestParam String locationName) {
        return brandSearchService.searchBrandInLocation(brandName, locationName);
    }


 /*   public ResponseEntity<BrandSearchDTO> search(
            @RequestParam("brandName") String brandName,
            @RequestParam("locationName") String locationName) {
        BrandSearchDTO result = brandSearchService.searchBrandInLocation(brandName, locationName);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }*/

}
