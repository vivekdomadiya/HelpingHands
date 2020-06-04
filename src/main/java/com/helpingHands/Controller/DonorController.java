package com.helpingHands.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.helpingHands.Dao.Dao;
import com.helpingHands.Model.AcceptRequest;
import com.helpingHands.Model.DonationRequests;

@Controller
@RequestMapping("/donor")
public class DonorController {
	
	@Autowired
	Dao dao;
	
	@GetMapping({"","/"})
	public ModelAndView donorHome() {
		ModelAndView mv = new ModelAndView("donor/dashboard.jsp");
		
		Map<String, Long> map = new HashMap<>();
		map.put("countPandingDonation", dao.countPandingDonation(dao.logeedUser()));
		map.put("countTotalDonation", dao.countTotalDonation(dao.logeedUser()));
		map.put("countPandingRequest", dao.countDonorPandingRequest(dao.logeedUser()));

		mv.addObject("count",map);
		
		return mv;
	}
	
	@GetMapping("/make-donation")
	public ModelAndView makeDonation() {
		
		return new ModelAndView("donor/make-donation.jsp");
	}
	
	@PostMapping("/make-donation")
	public ModelAndView saveDonationRequest(@Valid DonationRequests request) {
		long id = dao.saveDonationRequest(request);
		return new ModelAndView("redirect:/donor/donation/" + id);
	}

	@GetMapping("/panding-donation")
	public ModelAndView pandingDoantion() {
		ModelAndView mv = new ModelAndView("donor/panding-donation.jsp");
		List<DonationRequests> myDonationRequests = dao.getPandingDonationRequests(dao.logeedUser());
		mv.addObject("myDonationRequests", myDonationRequests);
		return mv;
	}
	
	@PostMapping("/panding-donation")
	public ModelAndView postPandingDonation(@RequestParam("bulk_options") String bulk_options,@RequestParam("requestIdsList") List<Long> requestIdsList) {
		String msg = "Somthing Went Wrong! Try again!!";
		String msgClass="danger";
		if(bulk_options.equals("PICK-UP") || bulk_options.equals("DROP")) {
			List<DonationRequests> drs = dao.findDonationById(requestIdsList);
			for(DonationRequests dr: drs) {
				dr.setTypeOfTransoprt(bulk_options);
			}
			dao.updateDonationRequest(drs);
			msg = "Successfully Change to "+ bulk_options + " All Selected Donation.";
			msgClass = "success";
		} else if(bulk_options.equals("Delete")) {
			dao.deleteDonationRequest(requestIdsList);
			msg = "Successfully Deleted All Selected Donation.";
			msgClass = "success";
		}
		return new ModelAndView("redirect:/donor/panding-donation?msg="+msg+"&msgClass="+msgClass);
	}
	
	@PostMapping("/deleteDonation")
	public ModelAndView deletePandingDonation(@RequestParam("deleteId") long requestId) {
		String msg = "Somthing Went Wrong! Try again!!";
		String msgClass="danger";
		dao.deleteDonationRequest(requestId);
		msg = "Successfully Deleted Donation.";
		msgClass = "success";
		return new ModelAndView("redirect:/donor/panding-donation?msg="+msg+"&msgClass="+msgClass);
	}
	
	@GetMapping("/panding-requests")
	public ModelAndView pandingRequests() {
		ModelAndView mv = new ModelAndView("donor/panding-requests.jsp");
		List<AcceptRequest> ars = dao.getDonorPandingRequests(dao.logeedUser());
		mv.addObject("requests", ars);
		return mv;
	}	
	
	@GetMapping("/my-donations")
	public ModelAndView yourDoantion() {
		ModelAndView mv = new ModelAndView("donor/my-donations.jsp");
		List<DonationRequests> myDonationRequests = dao.getAllDonationRequests(dao.logeedUser());
		mv.addObject("myDonationRequests", myDonationRequests);
		return mv;
	}
	
	@GetMapping("/donation/{id}")
	public ModelAndView donation(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("donor/donation.jsp");
		DonationRequests dr = dao.findDonationById(id);
		mv.addObject("donation", dr);
		return mv;
	}
	
	@PostMapping("/ApproveRequest")
	public ModelAndView approveRequest(final long approveId) {
		String msg = "Somthing Went Wrong! Try again!!";
		String msgClass="danger";
		
		dao.approveRequest(approveId);
		
		msg = "Successfully Approved Request.";
		msgClass = "success";
		return new ModelAndView("redirect:/donor/panding-requests?msg="+msg+"&msgClass="+msgClass);
	}
	
	@PostMapping("/UnapproveRequest")
	public ModelAndView unapproveRequest(final long unapproveId) {	
		String msg = "Somthing Went Wrong! Try again!!";
		String msgClass="danger";
		
		dao.unapproveRequest(unapproveId);
		
		msg = "Successfully Unapproved Request.";
		msgClass = "success";
		
		return new ModelAndView("redirect:/donor/panding-requests?msg="+msg+"&msgClass="+msgClass);
	}
}
