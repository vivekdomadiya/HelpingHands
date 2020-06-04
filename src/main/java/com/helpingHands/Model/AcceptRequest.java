package com.helpingHands.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
public class AcceptRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long acceptId;
	
	@Column(nullable = false)
	private String howToUse;
	
	private String status = "PANDING";
	
	private Date appliedDate = new Date();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "receiverId",referencedColumnName = "userId")
	User receiver;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "donationRequestId",referencedColumnName = "requestId")
	DonationRequests donationRequest;

	public long getAcceptId() {
		return acceptId;
	}

	public void setAcceptId(long acceptId) {
		this.acceptId = acceptId;
	}

	public String getHowToUse() {
		return howToUse;
	}

	public void setHowToUse(String howToUse) {
		this.howToUse = howToUse;
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

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public DonationRequests getDonationRequest() {
		return donationRequest;
	}

	public void setDonationRequest(DonationRequests donationRequest) {
		this.donationRequest = donationRequest;
	}
	
}
