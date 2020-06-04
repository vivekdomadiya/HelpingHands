package com.helpingHands.Model;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Token {

	private static final int EXPIRATION = 60 * 24;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long tokenId;

	@Column(nullable = false, unique = true)
	private String tokenValue;
	
	@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "userId")
    private User user;
	
	@Column(nullable = false)
	private Date expiryDate;

	public Token() {
		this.tokenValue = UUID.randomUUID().toString();
		this.setExpiryDate(EXPIRATION);
	}
	
	public Token(User user) {
		this.tokenValue = UUID.randomUUID().toString();
		this.user = user;
		this.setExpiryDate(EXPIRATION);
	}
	
	public long getTokenId() {
		return tokenId;
	}

	public void setTokenId(long tokenId) {
		this.tokenId = tokenId;
	}

	public String getTokenValue() {
		return tokenValue;
	}

	public void setTokenValue(String tokenValue) {
		this.tokenValue = tokenValue;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public void setExpiryDate(int minutes){
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MINUTE, minutes);
        this.expiryDate = now.getTime();
    }
	
	public boolean isExpired() {
        return new Date().after(this.expiryDate);
    }
}
