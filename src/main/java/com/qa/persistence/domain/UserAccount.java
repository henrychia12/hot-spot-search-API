package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class UserAccount {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long userID;
	private String userName;
	private String userFullName;
	private String emailAddress;
	private String password;
	

	public UserAccount() {

	}

	public UserAccount(String userName, String userFullName, String emailAddress) {
		this.userName = userName;
		this.userFullName = userFullName;
		this.emailAddress = emailAddress;
	}

	public Long getId() {
		return userID;
	}

	public void setId(Long id) {
		this.userID = id;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	@Override
	public String toString() {
		return "Username: " + userName + ", Full Name: " + userFullName + ", Email Address: " + emailAddress ;
	}

}