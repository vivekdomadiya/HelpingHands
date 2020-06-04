package com.helpingHands.Model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class DonationRequests {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long requestId;
	
	@Column(nullable = false)
	private String typeOfRequest;
	
	@Column(nullable = false)
	private String nameOfRequest;
	
	@Column(nullable = false)
	private String quantity;
	
	@Column(nullable = false)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dateOfDonate;
	
	@Column(nullable = false)
	private String typeOfTransoprt;
	
	@Column(nullable = false)
	private String addL1;
	@Column(nullable = false)
	private String addL2;
	@Column(nullable = false)
	private String city;
	@Column(nullable = false)
	private String state;
	@Column(nullable = false)
	private String pinCode;
	
	private String details;
	
	private String status = "PANDING";
	
	private Date appliedDate=new Date();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "donorId",referencedColumnName = "userId")
	User donor;
	
	@OneToMany(mappedBy = "donationRequest",cascade = CascadeType.ALL)
	private List<AcceptRequest> acceptRequest;

	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}

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

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
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

	public String getAddL1() {
		return addL1;
	}

	public void setAddL1(String addL1) {
		this.addL1 = addL1;
	}

	public String getAddL2() {
		return addL2;
	}

	public void setAddL2(String addL2) {
		this.addL2 = addL2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getAppliedDate() {
		return appliedDate;
	}

	public void setAppliedDate(Date appliedDate) {
		this.appliedDate = appliedDate;
	}

	public User getDonor() {
		return donor;
	}

	public void setDonor(User donor) {
		this.donor = donor;
	}

	public List<AcceptRequest> getAcceptRequest() {
		return acceptRequest;
	}

	public void setAcceptRequest(List<AcceptRequest> acceptRequest) {
		this.acceptRequest = acceptRequest;
	}	
	
}
