package com.qa.business.service;

public interface UserAccountService {
	
	String getAllAccounts();

	String createAccount(String userAccount);
	
	String updateAccount(Long userID, String userFullName);

	String deleteAccount(Long userID);

}
