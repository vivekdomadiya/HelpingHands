package com.helpingHands.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.helpingHands.Dto.DonationRequestSearch;
import com.helpingHands.Email.EmailSender;
import com.helpingHands.Model.AcceptRequest;
import com.helpingHands.Model.Admin;
import com.helpingHands.Model.DonationRequests;
import com.helpingHands.Model.Token;
import com.helpingHands.Model.User;
import com.helpingHands.Repository.AcceptRequestRepository;
import com.helpingHands.Repository.AdminRepo;
import com.helpingHands.Repository.DonationRequestsRepository;
import com.helpingHands.Repository.TokenRepository;
import com.helpingHands.Repository.UsersRepository;
import com.helpingHands.Security.userdetails;
import com.helpingHands.Specifications.AcceptRequestSpecification;
import com.helpingHands.Specifications.DonationRequestSpecification;

@Component
@Scope("prototype")
public class Dao {

	@Autowired
	EmailSender emailSender;

	@Autowired
	AdminRepo adminRepo;

	@Autowired
	UsersRepository userRepo;
	
	@Autowired
	TokenRepository tokenRepo;

	@Autowired
	DonationRequestsRepository donationRequestsRepo;
	
	@Autowired
	AcceptRequestRepository acceptRequestRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	public userdetails currentUser() {
		return (userdetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
	
	public User logeedUser() {
		userdetails userdetail = (userdetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return userRepo.findByEmail(userdetail.getEmail());
	}
	
	private static Sort sortBy(final String colName) {
		return Sort.by(Sort.Direction.DESC, colName);
	}
	private static PageRequest pageRequest(final int pageNo,final int limit) {
		return PageRequest.of(pageNo-1,limit);
	}
	private static PageRequest pageRequest(final int pageNo,final int limit,final Sort sort) {
		return PageRequest.of(pageNo-1,limit,sort);
	}
	
	// TOKEN
	public Token createToken(final User user) {
		Token token = new Token(user);
		tokenRepo.save(token);
		return token;
	}
	public Token getToken(final String tokenValue) {
		return tokenRepo.findByTokenValue(tokenValue);
	}
	private User getUser(final String tokenValue) {
		Token token = getToken(tokenValue);
		if(token!=null)
			return token.getUser();
		return null;
	}
	public boolean isTokenExpired(final String tokenValue) {
		Token token = getToken(tokenValue);
		if(token==null)
			return true;
		
		if(token.isExpired())
			return true;
		return false;
	}
	private void deleteToken(String tokenValue) {
		tokenRepo.delete(getToken(tokenValue));
	}
	
	
	// USERS
	public boolean emailExists(final String email) {
        return userRepo.findByEmail(email) != null;
    }
	
	// save User
	public void saveUser(final User user) {
		
		if(user.getRole().equals("donor"))
			user.setRole("ROLE_DONOR");
		else
			user.setRole("ROLE_RECEIVER");
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepo.save(user);
		
		Token token = createToken(user);
		emailSender.createAccountMail(user.getName(),user.getEmail(),token.getTokenValue());
	}
	
	// confirm-account
	public boolean validateEmail(final String tokenValue) {
		User existUser = getUser(tokenValue);

		if (existUser != null) {
			existUser.setActive(true);
			userRepo.save(existUser);
			deleteToken(tokenValue);
			return true;
		}
		return false;
	}

	public boolean confirmAccount(final String tokenValue) {
		if(!isTokenExpired(tokenValue)) {
			User user = getUser(tokenValue);
			user.setActive(true);
			updateUser(user);
			return true;
		}
		return false;
	}

	//reset password email sender
	public boolean sendResetPasswordEmail(final String email) {
		User user = userRepo.findByEmail(email);
		if (user != null) {
			Token token = createToken(user);
			emailSender.createResetPasswordMail(email, token.getTokenValue());
			return true;
		}
		return false;
	}

	//reset password update
	public void resetPassword(final String tokenValue,final String password) {
		User existUser = getUser(tokenValue);
		changePassword(existUser, password);
		
		deleteToken(tokenValue);
	}

	public void changePassword(final User user, final String password) {
        user.setPassword(passwordEncoder.encode(password));
        user.setActive(true);
        userRepo.save(user);
    }
	
	public boolean checkIfValidOldPassword(final String oldPassword) {
        return passwordEncoder.matches(oldPassword, logeedUser().getPassword());
    }

	// get Users
	public Page<User> getAllUsers(final int pageNo,final int limit) {
		return userRepo.findAll(pageRequest(pageNo, limit, sortBy("userId")));
	}
	// delete user
	public void deleteUser(final long requestId) {
		userRepo.deleteById(requestId);
	}
	// update user
	public void updateUser(final User user) {
		userRepo.save(user);
	}
	
	
	// Donation Request
	// Save Donation Request
	public long saveDonationRequest(final DonationRequests request) {
		request.setDonor(logeedUser());
		DonationRequests ds = donationRequestsRepo.save(request);
		return ds.getRequestId();
	}
	//  Update Donation Request
	public void updateDonationRequest(final DonationRequests request) {
		donationRequestsRepo.save(request);
	}
	public void updateDonationRequest(final List<DonationRequests> drs) {
		donationRequestsRepo.saveAll(drs);
	}
	//  Delete Donation Request
	public void deleteDonationRequest(final long id) {
		donationRequestsRepo.deleteById(id);
	}
	public void deleteDonationRequest(final List<Long> Ids) {
		List<DonationRequests> drs = donationRequestsRepo.findAllById(Ids);
		donationRequestsRepo.deleteAll(drs);
	}

	
	// Donation Request find by id
	public DonationRequests findDonationById(final long id) {
		return donationRequestsRepo.findById(id).orElse(null);
	}
	public List<DonationRequests> findDonationById(final List<Long> id) {
		return donationRequestsRepo.findAllById(id);
	}

	// get Donation requests
	public Page<DonationRequests> getPandingDonationByCity(final String city,final int pageNo,final int limit) {
		return donationRequestsRepo.findAll(
				DonationRequestSpecification.getByCity(city),
				pageRequest(pageNo, limit, sortBy("requestId")));
	}
	public List<DonationRequests> getPandingDonationRequests(final User user) {
		
		return donationRequestsRepo.findAll(Specification.where(
				DonationRequestSpecification.getByDonor(user)
				.and(DonationRequestSpecification.getByStatus("PANDING"))
				), sortBy("requestId"));
	}
	public List<DonationRequests> getAllDonationRequests(final User user) {
		return donationRequestsRepo.findAll(DonationRequestSpecification.getByDonor(user),sortBy("requestId"));
	}

	
	// Accept Requests
	
	private boolean existRequest(final User user, final DonationRequests donationRequest) {
		AcceptRequest ar = acceptRequestRepo.findOne(Specification.where(
				AcceptRequestSpecification.getByDonationRequest(donationRequest)
				.and(AcceptRequestSpecification.getByReceiver(user))
				)).orElse(null);
		if(ar!=null)
			return true;
		return false;
	}
	
	//	Save Accept Request
	public void saveAcceptRequest(final long donationRequestId,final String howToUse) {
		DonationRequests dr = findDonationById(donationRequestId);
		if(!existRequest(logeedUser(), dr)) {
			AcceptRequest ar = new AcceptRequest();
			ar.setHowToUse(howToUse);
			ar.setReceiver(logeedUser());
			ar.setDonationRequest(dr);
			
			acceptRequestRepo.save(ar);
		}
	}
	// Update Accept Request
	public void updateAcceptRequest(final AcceptRequest acceptRequest) {
		acceptRequestRepo.save(acceptRequest);
	}
	public void updateAcceptRequest(final List<AcceptRequest> acceptRequests) {
		acceptRequestRepo.saveAll(acceptRequests);
	}
	// Delete Accept Request
	public void deleteAcceptRequest(final long id) {
		acceptRequestRepo.deleteById(id);
	}
	

	//	Get Accept Request
	public List<AcceptRequest> getReceiverAcceptRequests(final User user) {
//		return acceptRequestRepo.findByReceiverEmail(currentUser().getEmail());
		return acceptRequestRepo.findAll(AcceptRequestSpecification.getByReceiver(user), sortBy("acceptId"));
	}
	public List<AcceptRequest> getReceiverPandingAcceptRequests(final User user) {
		return acceptRequestRepo.findAll(Specification.where(
				AcceptRequestSpecification.getByReceiver(user)
				.and(AcceptRequestSpecification.getByStatus("PANDING"))
				), sortBy("acceptId"));
	}
	public List<AcceptRequest> getDonorPandingRequests(final User user) {
//		return acceptRequestRepo.findByDonorEmail(currentUser().getEmail());
		return acceptRequestRepo.findAll(Specification.where(
				AcceptRequestSpecification.getByDonor(user)
				.and(AcceptRequestSpecification.getByStatus("PANDING"))), sortBy("acceptId"));
	}
	
	
	// Approve Accept Request
	public void approveRequest(long approveId) {
		AcceptRequest ar = acceptRequestById(approveId);

		DonationRequests dr = donationRequestsRepo.findByAcceptRequest(ar);
		List<AcceptRequest> ars = acceptRequestRepo.findAll(AcceptRequestSpecification.getByDonationRequest(dr));
	
		for(AcceptRequest request : ars) 
			request.setStatus("UNAPPROVED");
		updateAcceptRequest(ars);
		
		ar.setStatus("APPROVED");
		updateAcceptRequest(ar);
		
		dr.setStatus("APPROVED");
		updateDonationRequest(dr);
	}

	// Unapprove Accept Request
	public void unapproveRequest(final long unapproveId) {
		AcceptRequest ar = acceptRequestById(unapproveId);

		ar.setStatus("UNAPPROVED");
		updateAcceptRequest(ar);
	}
	
	

	//	Find Accept Request by Id
	public AcceptRequest acceptRequestById(long acceptId) {
		return acceptRequestRepo.getOne(acceptId);
	}

	public Page<AcceptRequest> getAllRequests(final int pageNo,final int limit) {
		return acceptRequestRepo.findAll(pageRequest(pageNo, limit, sortBy("acceptId")));
	}

	public Page<DonationRequests> getAllDonationRequests(final int pageNo,final int limit) {
		return donationRequestsRepo.findAll(pageRequest(pageNo, limit, sortBy("requestId")));
	}

	// Dashboard
	// Count Request
	public long countPandingDonation(final User user) {
		return donationRequestsRepo.count(Specification.where(
				DonationRequestSpecification.getByDonor(user)
				.and(DonationRequestSpecification.getByStatus("PANDING"))
				));
	}
	
	public Long countApprovedDonation(final User user) {
		return donationRequestsRepo.count(Specification.where(
				DonationRequestSpecification.getByDonor(user)
				.and(DonationRequestSpecification.getByStatus("APPROVED"))
				));
	}

	public long countTotalDonation(final User user) {
		return donationRequestsRepo.count(Specification.where(
				DonationRequestSpecification.getByDonor(user)
				));
	}

	public long countDonorPandingRequest(final User user) {
		return acceptRequestRepo.count(Specification.where(
				AcceptRequestSpecification.getByDonor(user)
				.and(AcceptRequestSpecification.getByStatus("PANDING"))
				));
	}

	public Long countReceiverPandingRequest(final User user) {
		return acceptRequestRepo.count(Specification.where(
				AcceptRequestSpecification.getByReceiver(user)
				.and(AcceptRequestSpecification.getByStatus("PANDING"))
				));
	}

	public Long countApprovedRequest(final User user) {
		return acceptRequestRepo.count(Specification.where(
				AcceptRequestSpecification.getByReceiver(user)
				.and(AcceptRequestSpecification.getByStatus("APPROVED"))
				));
	}

	public Long countTotalRequest(final User user) {
		return acceptRequestRepo.count(AcceptRequestSpecification.getByReceiver(user));
	}

	public Long countPandingRequest(final User user) {
		return acceptRequestRepo.count(Specification.where(
				AcceptRequestSpecification.getByStatus("PANDING")
				));
	}

	public Long countTotalDonor() {
		return userRepo.countByRole("ROLE_DONOR");
	}
	public Long countTotalReceiver() {
		return userRepo.countByRole("ROLE_RECEIVER");
	}
	public Long countTotalUser() {
		return userRepo.count();
	}

	public boolean checkAdminOldPassword(final String oldPassword) {
		Admin admin = adminRepo.findByEmail(currentUser().getEmail());
		return passwordEncoder.matches(oldPassword, admin.getPassword());
	}

	public void changeAdminPassword(final String newPassword) {
		Admin admin = adminRepo.findByEmail(currentUser().getEmail());
		admin.setPassword(passwordEncoder.encode(newPassword));
		adminRepo.save(admin);
	}

	
	// SEARCH DONATION REQUEST
	public Page<DonationRequests> SeachDonation(final DonationRequestSearch search,final int pageNo,final int limit) {
		return donationRequestsRepo.findAll(Specification.where(
				DonationRequestSpecification.getByType(search.getTypeOfRequest())
				.and(DonationRequestSpecification.getByName(search.getNameOfRequest()))
				.and(DonationRequestSpecification.getByDateLessThen(search.getDateOfDonate()))
				.and(DonationRequestSpecification.getByTransportType(search.getTypeOfTransoprt()))
				.and(DonationRequestSpecification.getByCity(search.getCity()))
				
				), pageRequest(pageNo, limit));
	}

}