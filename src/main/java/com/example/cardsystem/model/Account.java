package com.example.cardsystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "account")
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    private Boolean activeStatus;
    private Double currentBalance;
    private Double creditLimit;
    private Double cashCreditLimit;
    private String accountOpenDate;
    private String expirationDate;
    private String reissueDate;
    private String statementDate;
    private Double currentCycCredit;
    private Double currentCycDebit;
    private Integer groupId;
	public Object getActiveStatus() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getCurrentBalance() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setActiveStatus(Object activeStatus2) {
		// TODO Auto-generated method stub
		
	}
	public void setCurrentBalance(Object currentBalance2) {
		// TODO Auto-generated method stub
		
	}
	public Object getCreditLimit() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setCreditLimit(Object creditLimit2) {
		// TODO Auto-generated method stub
		
	}
	public Object getAccountOpenDate() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setAccountOpenDate(Object accountOpenDate2) {
		// TODO Auto-generated method stub
		
	}
	public Object getExpirationDate() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setExpirationDate(Object expirationDate2) {
		// TODO Auto-generated method stub
		
	}
	public Object getReissueDate() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setReissueDate(Object reissueDate2) {
		// TODO Auto-generated method stub
		
	}
	public Object getStatementDate() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setStatementDate(Object statementDate2) {
		// TODO Auto-generated method stub
		
	}
	public Object getCurrentCycCredit() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setCurrentCycCredit(Object currentCycCredit2) {
		// TODO Auto-generated method stub
		
	}
	public Object getCurrentCycDebit() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setCurrentCycDebit(Object currentCycDebit2) {
		// TODO Auto-generated method stub
		
	}
	public Object getGroupId() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setGroupId(Object groupId2) {
		// TODO Auto-generated method stub
		
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public Double getCashCreditLimit() {
		return cashCreditLimit;
	}
	public void setCashCreditLimit(Double cashCreditLimit) {
		this.cashCreditLimit = cashCreditLimit;
	}
	public void setActiveStatus(Boolean activeStatus) {
		this.activeStatus = activeStatus;
	}
	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}
	public void setCreditLimit(Double creditLimit) {
		this.creditLimit = creditLimit;
	}
	public void setAccountOpenDate(String accountOpenDate) {
		this.accountOpenDate = accountOpenDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public void setReissueDate(String reissueDate) {
		this.reissueDate = reissueDate;
	}
	public void setStatementDate(String statementDate) {
		this.statementDate = statementDate;
	}
	public void setCurrentCycCredit(Double currentCycCredit) {
		this.currentCycCredit = currentCycCredit;
	}
	public void setCurrentCycDebit(Double currentCycDebit) {
		this.currentCycDebit = currentCycDebit;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
}

