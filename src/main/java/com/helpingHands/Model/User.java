package com.helpingHands.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	
	private String role;
	private String name;
	
	@Column(nullable = false, unique = true)
	@Email
	private String email;

	private String contact;
	
	@JsonIgnore
	private String password;
	
	private String addL1;
	private String addL2;
	private String city;
	private String state;
	private String pinCode;
	
	private boolean active = false;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddL1() {
		return addL1;
	}

	public void setAddL1(String addL1) {
		this.addL1 = addL1;
	}

	public String getAddL2() {
		return addL2;
	}

	public void setAddL2(String addL2) {
		this.addL2 = addL2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "User ["
				+ "userId=" + userId + ", "
				+ "role=" + role + ", "
				+ "name=" + name + ", "
				+ "email=" + email + ", "
				+ "contact=" + contact + ", "
				+ "addL1=" + addL1 + ", "
				+ "addL2=" + addL2 + ", "
				+ "city=" + city + ", "
				+ "state=" + state + ", "
				+ "pinCode=" + pinCode + ", "
				+ "active=" + active
				+ "]";
	}
	
}
