package com.rko.springsecurity.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "generic")
public class Generic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @OneToMany(mappedBy = "generic", cascade = CascadeType.ALL)
    private List<Brand> brands;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    // Constructors, getters, and setters
}
