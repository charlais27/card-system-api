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
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public Integer getTranTypeCd() {
		return tranTypeCd;
	}
	public void setTranTypeCd(Integer tranTypeCd) {
		this.tranTypeCd = tranTypeCd;
	}
	public Integer getTranCatCd() {
		return tranCatCd;
	}
	public void setTranCatCd(Integer tranCatCd) {
		this.tranCatCd = tranCatCd;
	}
	public Double getTranCatBal() {
		return tranCatBal;
	}
	public void setTranCatBal(Double tranCatBal) {
		this.tranCatBal = tranCatBal;
	}
}
