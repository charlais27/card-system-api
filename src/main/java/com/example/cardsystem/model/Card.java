package com.example.cardsystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "card")
@Data
public class Card {
    @Id
    private String cardNumber;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    private String cvv;
    private String embossedName;
    private String expirationDate;
    private Boolean activeStatus;
}
