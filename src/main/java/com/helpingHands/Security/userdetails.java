package com.helpingHands.Security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.helpingHands.Model.Admin;
import com.helpingHands.Model.User;

public class userdetails implements UserDetails {

	private static final long serialVersionUID = 8949645850348453692L;
	
	String email;
	String password;
	String role;
	String city;
	boolean active;
	
	public userdetails(){
		this.email=null;
		this.password=null;
		this.role=null;
		this.city=null;
		this.active=false;
	}
	
	public userdetails(User user) {
		this.email=user.getEmail();
		this.password=user.getPassword();
		this.role=user.getRole();
		this.city=user.getCity();
		this.active=user.isActive();
	}
	
	public userdetails(Admin admin) {
		this.email=admin.getEmail();
		this.password=admin.getPassword();
		this.role=admin.getRole();
		this.city="ALL";
		this.active=admin.isActive();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority(role));
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return active;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
