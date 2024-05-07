package com.rko.springsecurity.service;

import com.rko.springsecurity.domain.Brand;
import com.rko.springsecurity.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public String getBrandByName(String brandName) {
        Optional<Brand> brandOptional = brandRepository.findByBrandName(brandName);
        return brandOptional.map(Brand::getBrandName).orElse(null);
    }
}
