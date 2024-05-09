package com.rko.springsecurity.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "location_name", unique = true)
    private String locationName;
    private double latitude;
    private double longitude;

/* @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Brand> brands;*/

   /* @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Generic> generics;*/

  /*  @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Prescription> prescriptions;*/

    @OneToMany(mappedBy = "location", fetch = FetchType.EAGER)
    private Set<Prescription> prescriptions;

    // Constructors, getters, and setters
}