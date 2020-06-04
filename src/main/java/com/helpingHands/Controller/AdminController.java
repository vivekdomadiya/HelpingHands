package com.helpingHands.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.helpingHands.Model.AcceptRequest;
import com.helpingHands.Model.DonationRequests;
import com.helpingHands.Model.User;
import com.helpingHands.Dao.Dao;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private static final int limit = 20;
	
	@Autowired
	Dao dao;
	
	@GetMapping({"","/"})
	public ModelAndView adminHome() {
		ModelAndView mv = new ModelAndView("admin/dashboard.jsp");
		
		Map<String, Long> map = new HashMap<>();
		map.put("countPandingDonation", dao.countPandingDonation(dao.logeedUser()));
		map.put("countApprovedDonation", dao.countApprovedDonation(dao.logeedUser()));
		map.put("countTotalDonation", dao.countTotalDonation(dao.logeedUser()));
		map.put("countPandingRequest", dao.countPandingRequest(dao.logeedUser()));
		map.put("countApprovedRequest", dao.countApprovedRequest(dao.logeedUser()));
		map.put("countTotalRequest", dao.countTotalRequest(dao.logeedUser()));
		map.put("countTotalDonor", dao.countTotalDonor());
		map.put("countTotalReceiver", dao.countTotalReceiver());
		map.put("countTotalUser", dao.countTotalUser());

		mv.addObject("count",map);
		mv.addObject("user",dao.logeedUser());
		
		return mv;
	}

	@GetMapping("/view-all-donations")
	public ModelAndView viewAllDoantions(@RequestParam(name="page",defaultValue="1") int pageNo) {
		ModelAndView mv = new ModelAndView("admin/view-all-donations.jsp");
		
		Page<DonationRequests> page = dao.getAllDonationRequests(pageNo,limit);
		List<DonationRequests> requests = page.getContent();
		mv.addObject("donationRequests",requests);
		mv.addObject("pageNo", pageNo);
		mv.addObject("totalPageNo", page.getTotalPages());
		
		return mv;
	}
	
	@PostMapping("/deleteDonation")
	public ModelAndView deleteDonation(@RequestParam("deleteId") long requestId) {
		dao.deleteDonationRequest(requestId);
		String msg = "Successfully Donation Deleted";
		String msgClass="success";
		return new ModelAndView("redirect:/admin/view-all-donations?msg="+msg+"&msgClass="+msgClass);
	}
	
	@GetMapping("/view-all-requests")
	public ModelAndView viewAllRequests(@RequestParam(name="page",defaultValue="1") int pageNo) {
		ModelAndView mv = new ModelAndView("admin/view-all-requests.jsp");

		Page<AcceptRequest> page = dao.getAllRequests(pageNo,limit);
		List<AcceptRequest> requests = page.getContent();
		mv.addObject("requests",requests);
		mv.addObject("pageNo", pageNo);
		mv.addObject("totalPageNo", page.getTotalPages());
		
		return mv;
	}	
	
	@GetMapping("/view-all-users")
	public ModelAndView viewAllUsers(@RequestParam(name="page",defaultValue="1") int pageNo) {
		
		ModelAndView mv = new ModelAndView("admin/view-all-users.jsp");
		
		Page<User> page = dao.getAllUsers(pageNo,limit);
		List<User> users = page.getContent();
		mv.addObject("users",users);
		mv.addObject("pageNo", pageNo);
		mv.addObject("totalPageNo", page.getTotalPages());
		
		return mv;
	}
	
	@PostMapping("/deleteUser")
	public ModelAndView deleteUser(@RequestParam("deleteId") long requestId) {
		dao.deleteUser(requestId);
		return new ModelAndView("redirect:/admin/view-all-donations");
	}
	
	@GetMapping("/change-password")
	public ModelAndView changePassword() {
		ModelAndView mv = new ModelAndView("admin/change-password.jsp");
		return mv;
	}
	
	@PostMapping("/change-password")
	public ModelAndView changePassword(final String oldPassword,final String newPassword) {
		ModelAndView mv = new ModelAndView();
		if(dao.checkAdminOldPassword(oldPassword))
		{
			dao.changeAdminPassword(newPassword);
			mv.setViewName("redirect:/login");
		} else {
			mv.setViewName("change-password.jsp");
			mv.addObject("error","true");
		}
		return mv;
	}

}
