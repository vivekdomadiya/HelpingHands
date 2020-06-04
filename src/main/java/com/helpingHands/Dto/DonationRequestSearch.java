package com.helpingHands.Dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class DonationRequestSearch {
	String typeOfRequest;
	String nameOfRequest;
	String typeOfTransoprt;
	String city;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	Date dateOfDonate;
	
	public String getTypeOfRequest() {
		return typeOfRequest;
	}
	public void setTypeOfRequest(String typeOfRequest) {
		this.typeOfRequest = typeOfRequest;
	}
	public String getNameOfRequest() {
		return nameOfRequest;
	}
	public void setNameOfRequest(String nameOfRequest) {
		this.nameOfRequest = nameOfRequest;
	}
	public Date getDateOfDonate() {
		return dateOfDonate;
	}
	public void setDateOfDonate(Date dateOfDonate) {
		this.dateOfDonate = dateOfDonate;
	}
	public String getTypeOfTransoprt() {
		return typeOfTransoprt;
	}
	public void setTypeOfTransoprt(String typeOfTransoprt) {
		this.typeOfTransoprt = typeOfTransoprt;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public boolean isNull() {
		if(this.typeOfRequest==null && this.nameOfRequest == null && this.dateOfDonate ==null && this.typeOfTransoprt == null && this.city == null)
			return true;
		return false;
	}
	@Override
	public String toString() {
		return "DonationRequestSearch [typeOfRequest=" + typeOfRequest + ", nameOfRequest=" + nameOfRequest
				+ ", dateOfDonate=" + dateOfDonate + ", typeOfTransoprt=" + typeOfTransoprt + ", city=" + city + "]";
	}

}
