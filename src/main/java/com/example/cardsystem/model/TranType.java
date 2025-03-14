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

	public Integer getTranTypeCd() {
		return tranTypeCd;
	}

	public void setTranTypeCd(Integer tranTypeCd) {
		this.tranTypeCd = tranTypeCd;
	}

	public String getTranTypeDescription() {
		return tranTypeDescription;
	}

	public void setTranTypeDescription(String tranTypeDescription) {
		this.tranTypeDescription = tranTypeDescription;
	}
}
