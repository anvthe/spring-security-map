package com.rko.springsecurity.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "drugs")
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "drug_name")
    @NotBlank
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    @ManyToOne
    @JoinColumn(name = "generic_id")
    private Generic generic;

 /*   public @NotBlank String getName() {
        return name;
    }*/

    /* @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;*/

   /* @OneToMany(mappedBy = "drug", fetch = FetchType.EAGER)
    private Set<Prescription> prescriptions;*/

    // Constructors, getters, and setters
}
