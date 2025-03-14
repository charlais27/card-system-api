package com.example.cardsystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "customer")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String firstName;
    private String middleName;
    private String lastName;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String state;
    private String countryCode;
    private String zip;
    private String phone1;
    private String phone2;
    private String ssn;
    private String govtIssuedId;
    private String dateOfBirth;
    private String eftAccountId;
    private Boolean principalCardHolderInd;
    private Integer ficoCreditScore;
	public Object getFirstName() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setFirstName(Object firstName2) {
		// TODO Auto-generated method stub
		
	}
	public Object getLastName() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setLastName(Object lastName2) {
		// TODO Auto-generated method stub
		
	}
	public void setEmail(Object email) {
		// TODO Auto-generated method stub
		
	}
	public Object getPhone() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setPhone(Object phone) {
		// TODO Auto-generated method stub
		
	}
	public Object getPhone_1() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setPhone_1(Object phone_1) {
		// TODO Auto-generated method stub
		
	}
	public Object getEftAccountId() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getPhone_2() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setPhone_2(Object phone_2) {
		// TODO Auto-generated method stub
		
	}
	public void setEftAccountId(Object eftAccountId2) {
		// TODO Auto-generated method stub
		
	}
	public Object getFicoCreditScore() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setFicoCreditScore(Object ficoCreditScore2) {
		// TODO Auto-generated method stub
		
	}
	public Object getPrincipalCardHolderInd() {
		// TODO Auto-generated method stub
		return null;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getAddressLine3() {
		return addressLine3;
	}
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getGovtIssuedId() {
		return govtIssuedId;
	}
	public void setGovtIssuedId(String govtIssuedId) {
		this.govtIssuedId = govtIssuedId;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEftAccountId(String eftAccountId) {
		this.eftAccountId = eftAccountId;
	}
	public void setPrincipalCardHolderInd(Boolean principalCardHolderInd) {
		this.principalCardHolderInd = principalCardHolderInd;
	}
	public void setFicoCreditScore(Integer ficoCreditScore) {
		this.ficoCreditScore = ficoCreditScore;
	}
}
