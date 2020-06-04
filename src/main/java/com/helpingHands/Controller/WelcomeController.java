package com.helpingHands.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.helpingHands.Dao.Dao;
import com.helpingHands.Model.User;

@RestController
public class WelcomeController {
	
	@Autowired
	Dao dao;
	
	@GetMapping({"/","/home"})
	public ModelAndView home() {
		return new ModelAndView("index.jsp");
	}
	
	@GetMapping("/about-us")
	public ModelAndView aboutUs() {
		return new ModelAndView("about-us.jsp");
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login.jsp");
	}
	
	@GetMapping("/sign-up")
	public ModelAndView signUp() {
		return new ModelAndView("sign-up.jsp");
	}
	
	@PostMapping("/sign-up")
	public ModelAndView saveUser(@Valid final User user) throws Exception {
		String msg = "Somthing Went Wrong! Try again!!";
		String msgClass="danger";
		
		ModelAndView mv = new ModelAndView();
		if(dao.emailExists(user.getEmail())) {
			mv.setViewName("sign-up.jsp");
			mv.addObject("user", user);
			mv.addObject("error", "Account already exists with this Email. Please <a href=\"/login\">Login here</a>.");
		} else {
			dao.saveUser(user);
			msg = "Successfully User Registered.";
			msgClass = "success";
			mv.setViewName("redirect:/login?msg="+msg+"&msgClass="+msgClass);
		}

		return mv;
	}
	
	@GetMapping("/confirm-account")
	public ModelAndView confirmAccount(@RequestParam("token") final String tokenValue) {
		String msg = "Somthing Went Wrong! Try again!!";
		String msgClass="danger";
		
		ModelAndView mv = new ModelAndView();
		if(dao.confirmAccount(tokenValue)) {
			msg = "Your Account Has been Confirmed.";
			msgClass = "success";
		} else {
			msg = "Link is invilid or broken. Do forgot password.";
			msgClass = "danger";
		}
		mv.setViewName("redirect:/login?msg="+msg+"&msgClass="+msgClass);
		return mv;
	}
	
	@GetMapping("/forgot-password")
	public ModelAndView forgotPassword() {
		return new ModelAndView("forgot-password.jsp");
	}
	
	@PostMapping("/forgot-password")
	public ModelAndView postForgotPassword(@RequestParam("email") final String email) {
		ModelAndView mv = new ModelAndView("forgot-password.jsp");
		if(dao.sendResetPasswordEmail(email)) {
			mv.addObject("email", email);
			mv.addObject("success", "true");
		}
		else {
			mv.addObject("error", "true");
		}
		return mv;
	}
	
	@GetMapping("/reset-password")
	public ModelAndView resetPassword(@RequestParam("token") final String tokenValue) {
		ModelAndView mv = new ModelAndView("resetPassword.jsp");
		if(dao.isTokenExpired(tokenValue)) {
			mv.addObject("linkBroken", "true");
		}
		return mv;
	}

	@PostMapping("/reset-password")
	public ModelAndView savePassword(@RequestParam("password") final String password ,@RequestParam("token") final String token) {
		dao.resetPassword(token, password);
		return new ModelAndView("redirect:/login");
	}
	
	@GetMapping("/change-password")
	public ModelAndView changePassword() {
		ModelAndView mv = new ModelAndView("change-password.jsp");
		return mv;
	}
	
	@PostMapping("/change-password")
	public ModelAndView changePassword(final String oldPassword,final String newPassword) {
		ModelAndView mv = new ModelAndView();
		if(dao.checkIfValidOldPassword(oldPassword))
		{
			dao.changePassword(dao.logeedUser(),newPassword);
			mv.setViewName("redirect:/login");
		} else {
			mv.setViewName("change-password.jsp");
			mv.addObject("error","true");
		}
		return mv;
	}
	
	@GetMapping("/edit-profile")
	public ModelAndView editProfile() {
		ModelAndView mv =new ModelAndView("edit-profile.jsp");
		User user = dao.logeedUser();
		mv.addObject("user", user);
		return mv;
	}
	
	@PostMapping("/edit-profile")
	public ModelAndView updateUser(final User user) {
		User loggedUser = dao.logeedUser();
		loggedUser.setName(user.getName());
		loggedUser.setContact(user.getContact());
		loggedUser.setAddL1(user.getAddL1());
		loggedUser.setAddL2(user.getAddL2());
		loggedUser.setCity(user.getCity());
		loggedUser.setState(user.getState());
		loggedUser.setPinCode(user.getPinCode());
		dao.updateUser(loggedUser);
		
		String url = "";
		if(loggedUser.getRole().equals("ROLE_DONOR"))
			url="/donor/";
		else if(loggedUser.getRole().equals("ROLE_RECEIVER"))
			url="/receiver/";
		else
			url="/error";
		
		String msg = "Your Profile Successfully Changed.";
		String msgClass = "success";
		return new ModelAndView("redirect:"+url+"?msg="+msg+"&msgClass="+msgClass);
	}

}
