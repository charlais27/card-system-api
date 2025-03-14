package com.example.cardsystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "account")
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    private Boolean activeStatus;
    private Double currentBalance;
    private Double creditLimit;
    private Double cashCreditLimit;
    private String accountOpenDate;
    private String expirationDate;
    private String reissueDate;
    private String statementDate;
    private Double currentCycCredit;
    private Double currentCycDebit;
    private Integer groupId;
}

