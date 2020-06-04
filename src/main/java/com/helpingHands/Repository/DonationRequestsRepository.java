package com.helpingHands.Repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.helpingHands.Model.AcceptRequest;
import com.helpingHands.Model.DonationRequests;

public interface DonationRequestsRepository extends JpaRepository<DonationRequests, Long>, JpaSpecificationExecutor<DonationRequests> {

	DonationRequests findByAcceptRequest(AcceptRequest acceptRequest);
	
	@Modifying
	@Query("update DonationRequests set status='REJECT' where dateOfDonate < ?1 ")
	public void rejectByDonationDate(Date now);
	
	
	
}
