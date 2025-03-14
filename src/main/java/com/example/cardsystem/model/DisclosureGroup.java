package com.example.cardsystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "disclosure_group")
@Data
public class DisclosureGroup {
    @Id
    private Integer acctGroupId;

    private Integer tranTypeCd;
    private Integer tranCatCd;
    private Double interestRate;
}
