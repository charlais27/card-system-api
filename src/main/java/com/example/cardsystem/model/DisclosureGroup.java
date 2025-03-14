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
	public Integer getAcctGroupId() {
		return acctGroupId;
	}
	public void setAcctGroupId(Integer acctGroupId) {
		this.acctGroupId = acctGroupId;
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
	public Double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
}
