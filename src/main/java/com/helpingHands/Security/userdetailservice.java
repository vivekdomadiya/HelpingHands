package com.helpingHands.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.helpingHands.Model.Admin;
import com.helpingHands.Model.User;
import com.helpingHands.Repository.AdminRepo;
import com.helpingHands.Repository.UsersRepository;

@Service
public class userdetailservice implements UserDetailsService {
	@Autowired
	UsersRepository userRepo;
	
	@Autowired
	AdminRepo adminRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if(username.equals("admin@helpinghands.com"))
		{
			Admin admin=adminRepo.findByEmail(username);
			if(admin==null)
				throw new UsernameNotFoundException("404");
			return new userdetails(admin);
		} else {
			User user=userRepo.findByEmail(username);
			if(user==null)
				throw new UsernameNotFoundException("404");
			return new userdetails(user);
		}
	}

}
