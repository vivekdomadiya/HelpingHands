package com.helpingHands.Specifications;

import javax.persistence.criteria.Join;

import org.springframework.data.jpa.domain.Specification;

import com.helpingHands.Model.AcceptRequest;
import com.helpingHands.Model.DonationRequests;
import com.helpingHands.Model.User;

public class AcceptRequestSpecification {

	public static Specification<AcceptRequest> getByReceiver(User receiver) {
		return (root, query, cb) -> {
			if(receiver==null)
				return null;
			
			return cb.equal(root.get("receiver"), receiver);			
		}; 
	}
	
	public static Specification<AcceptRequest> getByDonor(User donor) {
		return (root, query, cb) -> {
			if(donor==null)
				return null;
			
			Join<AcceptRequest, DonationRequests> donationRequest = root.join("donationRequest");
			return cb.equal(donationRequest.get("donor"), donor);
		}; 
	}
	
	public static Specification<AcceptRequest> getByStatus(String status) {
		return (root, query, cb) -> {
			if(status==null)
				return null;
			
			return cb.equal(root.get("status"), status);
		}; 
	}
	
	public static Specification<AcceptRequest> getByDonationRequest(DonationRequests dr) {
		return (root, query, cb) -> {
			if(dr==null)
				return null;
			
			return cb.equal(root.get("donationRequest"), dr);
		}; 
	}
}
