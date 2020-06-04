package com.helpingHands.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.helpingHands.Dao.Dao;
import com.helpingHands.Dto.DonationRequestSearch;
import com.helpingHands.Model.AcceptRequest;
import com.helpingHands.Model.DonationRequests;

@Controller
@RequestMapping("/receiver")
public class ReceiverController {	
	
	@Autowired
	Dao dao;
	
	@GetMapping({"","/"})
	public ModelAndView receiverHome() {
		ModelAndView mv = new ModelAndView("receiver/dashboard.jsp");
		
		Map<String, Long> map = new HashMap<>();
		map.put("countPandingRequest", dao.countReceiverPandingRequest(dao.logeedUser()));
		map.put("countApprovedRequest", dao.countApprovedRequest(dao.logeedUser()));
		map.put("countTotalRequest", dao.countTotalRequest(dao.logeedUser()));

		mv.addObject("count",map);
		
		return mv;
	}
	
	@GetMapping("/panding-donation")
	public ModelAndView pandingDonation(DonationRequestSearch search, @RequestParam(name="page",defaultValue="1") int pageNo) {
		int limit = 12;
		ModelAndView mv = new ModelAndView("receiver/panding-donation.jsp");
		Page<DonationRequests> page = null;
		System.out.println(search);
		if(search.isNull()) {
			String city = dao.currentUser().getCity();
			page = dao.getPandingDonationByCity(city,pageNo,limit);
		} else {
			page = dao.SeachDonation(search,pageNo,limit);
		}
		List<DonationRequests> list = page.getContent();
		mv.addObject("donations",list);
		mv.addObject("pageNo", pageNo);
		mv.addObject("totalPageNo", page.getTotalPages());
		
		return mv;
	}
	
	@GetMapping("/donation/{id}")
	public ModelAndView donation(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("receiver/donation.jsp");
		DonationRequests dr = dao.findDonationById(id);
		mv.addObject("donation", dr);
		return mv;
	}
	
	@PostMapping("/accept-request")
	public ModelAndView saveAcceptRequest(@RequestParam long donationRequestId,@RequestParam String howToUse) {
		String msg = "Somthing Went Wrong! Try again!!";
		String msgClass="danger";
		dao.saveAcceptRequest(donationRequestId,howToUse);
		msg = "Successfully Make Request.";
		msgClass = "success";
		return new ModelAndView("redirect:/receiver/donation/"+donationRequestId+"?msg="+msg+"&msgClass="+msgClass);
	}
	
	@GetMapping("/panding-requests")
	public ModelAndView pandingRequest() {
		ModelAndView mv = new ModelAndView("receiver/panding-requests.jsp");
		List<AcceptRequest> ars = dao.getReceiverPandingAcceptRequests(dao.logeedUser());
		mv.addObject("myAcceptRequests", ars);
		return mv;
	}
	
	@PostMapping("/deleteRequest")
	public ModelAndView deletePandingRequest(@RequestParam("deleteId") long acceptId) {
		String msg = "Somthing Went Wrong! Try again!!";
		String msgClass="danger";
		dao.deleteAcceptRequest(acceptId);
		msg = "Successfully Deleted Request.";
		msgClass = "success";
		
		return new ModelAndView("redirect:/receiver/panding-requests?msg="+msg+"&msgClass="+msgClass);
	}
	
	@GetMapping("/my-requests")
	public ModelAndView myRequest() {
		ModelAndView mv = new ModelAndView("receiver/my-requests.jsp");
		List<AcceptRequest> ars = dao.getReceiverAcceptRequests(dao.logeedUser());
		mv.addObject("myAcceptRequests", ars);
		return mv;
	}
	
}
