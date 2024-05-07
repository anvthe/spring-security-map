package com.rko.springsecurity.dto;

import com.rko.springsecurity.domain.Location;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchResultDTO {
    private int brandUsersCount;
    private String brandName;
    private Location location;
    private String error;
}
