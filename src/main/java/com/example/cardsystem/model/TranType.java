package com.example.cardsystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tran_type")
@Data
public class TranType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tranTypeCd;

    private String tranTypeDescription;
}
