package com.helpingHands.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helpingHands.Model.Token;
import com.helpingHands.Model.User;

public interface TokenRepository extends JpaRepository<Token, Long> {
	
	Token findByTokenValue(String tokenValue);
	
	Token findByUser(User user);
	
}