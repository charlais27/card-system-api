package com.example.cardsystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tran_category_bal")
@Data
public class TranCategoryBal {
    @Id
    private Integer accountId;

    private Integer tranTypeCd;
    private Integer tranCatCd;
    private Double tranCatBal;
}
