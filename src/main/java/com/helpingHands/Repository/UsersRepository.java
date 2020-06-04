package com.helpingHands.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.helpingHands.Model.User;

public interface UsersRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
	
	User findByEmail(String email);

	Long countByRole(String role);

}