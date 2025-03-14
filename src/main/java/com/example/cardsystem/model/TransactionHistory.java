package com.example.cardsystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "transaction_history")
@Data
public class TransactionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tranId;

    private Integer tranTypeCd;
    private Integer tranCatCd;
    private String tranSource;
    private String tranDescription;
    private Double tranAmt;
    private String merchantId;
    private String merchantName;
    private String merchantCity;
    private String merchantState;
    private String merchantZip;
    private String tranTimestamp;
}
