package com.santiago.proyectohibernate.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "billing_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties("user")
public class BillingInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    @Column(name = "postal_code")
    private String postalCode;

    private String city;

    private String country;

    @Column(unique = true, nullable = false, updatable = false)
    private Long userId;

    // --------- Asociaciones ---------

    @OneToOne(mappedBy = "billingInfo", cascade = CascadeType.ALL)
    private User user;
}
