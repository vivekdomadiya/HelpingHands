package com.helpingHands.Specifications;

import java.util.Date;

import org.springframework.data.jpa.domain.Specification;

import com.helpingHands.Model.DonationRequests;
import com.helpingHands.Model.User;

public class DonationRequestSpecification {
	
	public static Specification<DonationRequests> getByType(String type) {
		return (root, query, cb) -> {
			if(type==null || type.equals("") || type.equals("ANY"))
				return null;
			
			return cb.equal(root.get("typeOfRequest"), type);
		}; 
	}
	
	public static Specification<DonationRequests> getByName(String name) {
		return (root, query, cb) -> {
			if(name==null || name.equals("") || name.equals("ANY"))
				return null;
			
			return cb.equal(root.get("nameOfRequest"), name);
		}; 
	}
	
	public static Specification<DonationRequests> getByTransportType(String transoprtType) {
		return (root, query, cb) -> {
			if(transoprtType==null || transoprtType.equals("ANY"))
				return null;
			
			return cb.equal(root.get("typeOfTransoprt"), transoprtType);
		};
	}
	
	public static Specification<DonationRequests> getByCity(String city) {
		return (root, query, cb) -> {
			if(city==null || city.equals("ANY"))
				return null;
			
			return cb.equal(root.get("city"), city);
		}; 
	}
	
	public static Specification<DonationRequests> getByStatus(String status) {
		return (root, query, cb) -> {
			if(status==null || status.equals("ANY"))
				return null;
			
			return cb.equal(root.get("status"), status);
		}; 
	}
	
	public static Specification<DonationRequests> getByDate(Date date) {
		return (root, query, cb) -> {
			if(date==null)
				return null;
			
			return cb.equal(root.get("dateOfDonate"), date);
		}; 
	}
	
	public static Specification<DonationRequests> getByDateLessThen(Date date) {
		return (root, query, cb) -> {
			if(date==null)
				return null;
			
			return cb.lessThanOrEqualTo(root.get("dateOfDonate"), date);
		}; 
	}
	
	public static Specification<DonationRequests> getByDonor(User donor) {
		return (root, query, cb) -> {
			if(donor==null)
				return null;
			
			return cb.equal(root.get("donor"), donor);
		}; 
	}

}
