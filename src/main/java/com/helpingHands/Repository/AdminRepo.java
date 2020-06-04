package com.helpingHands.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.helpingHands.Model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {
	public Admin findByEmail(String email);
}
