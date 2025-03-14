package com.example.cardsystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "customer")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String firstName;
    private String middleName;
    private String lastName;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String state;
    private String countryCode;
    private String zip;
    private String phone1;
    private String phone2;
    private String ssn;
    private String govtIssuedId;
    private String dateOfBirth;
    private String eftAccountId;
    private Boolean principalCardHolderInd;
    private Integer ficoCreditScore;
}
