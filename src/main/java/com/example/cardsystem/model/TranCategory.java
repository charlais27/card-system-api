package com.example.cardsystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tran_category")
@Data
public class TranCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tranCatCd;

    private Integer tranTypeCd;
    private String tranCatTypeDescription;
}
