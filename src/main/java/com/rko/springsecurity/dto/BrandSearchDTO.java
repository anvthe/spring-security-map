package com.rko.springsecurity.dto;

import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BrandSearchDTO {
    private String brandName;
    private String locationName;
    private double latitude;
    private double longitude;
    private int brandCount;
    private String error;
}
