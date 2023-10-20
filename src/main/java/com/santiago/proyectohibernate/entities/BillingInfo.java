package com.santiago.proyectohibernate.entities;

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
public class BillingInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    @Column(name = "postal_code")
    private String postalCode;

    private String city;

    private String country;

    @OneToOne(mappedBy = "billingInfo")
    private User user;
}
