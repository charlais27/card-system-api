package com.example.cardsystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "posted_transaction")
@Data
public class PostedTransaction {
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
    private String cardNumber;
    private String tranTimestamp;
	public Long getTranId() {
		return tranId;
	}
	public void setTranId(Long tranId) {
		this.tranId = tranId;
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
	public String getTranSource() {
		return tranSource;
	}
	public void setTranSource(String tranSource) {
		this.tranSource = tranSource;
	}
	public String getTranDescription() {
		return tranDescription;
	}
	public void setTranDescription(String tranDescription) {
		this.tranDescription = tranDescription;
	}
	public Double getTranAmt() {
		return tranAmt;
	}
	public void setTranAmt(Double tranAmt) {
		this.tranAmt = tranAmt;
	}
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public String getMerchantCity() {
		return merchantCity;
	}
	public void setMerchantCity(String merchantCity) {
		this.merchantCity = merchantCity;
	}
	public String getMerchantState() {
		return merchantState;
	}
	public void setMerchantState(String merchantState) {
		this.merchantState = merchantState;
	}
	public String getMerchantZip() {
		return merchantZip;
	}
	public void setMerchantZip(String merchantZip) {
		this.merchantZip = merchantZip;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getTranTimestamp() {
		return tranTimestamp;
	}
	public void setTranTimestamp(String tranTimestamp) {
		this.tranTimestamp = tranTimestamp;
	}
}
