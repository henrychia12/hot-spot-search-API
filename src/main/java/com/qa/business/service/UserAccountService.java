package com.qa.business.service;

public interface UserAccountService {
	
	String getAllAccounts();

	String createAccount(String userAccount);
	
	String updateAccount(Long userID, String userAccount);

	String deleteAccount(Long userID);

}
