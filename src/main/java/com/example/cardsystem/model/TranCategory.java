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
	public Integer getTranCatCd() {
		return tranCatCd;
	}
	public void setTranCatCd(Integer tranCatCd) {
		this.tranCatCd = tranCatCd;
	}
	public Integer getTranTypeCd() {
		return tranTypeCd;
	}
	public void setTranTypeCd(Integer tranTypeCd) {
		this.tranTypeCd = tranTypeCd;
	}
	public String getTranCatTypeDescription() {
		return tranCatTypeDescription;
	}
	public void setTranCatTypeDescription(String tranCatTypeDescription) {
		this.tranCatTypeDescription = tranCatTypeDescription;
	}
}
