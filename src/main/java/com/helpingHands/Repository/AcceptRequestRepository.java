package com.helpingHands.Repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.helpingHands.Model.AcceptRequest;

public interface AcceptRequestRepository extends JpaRepository<AcceptRequest, Long>, JpaSpecificationExecutor<AcceptRequest> {

	@Modifying
	@Query("update AcceptRequest set status='REJECT' where donationRequest.dateOfDonate < ?1 ")
	public void rejectByDonationDate(Date now);
}
