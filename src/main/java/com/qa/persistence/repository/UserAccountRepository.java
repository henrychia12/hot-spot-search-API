package com.qa.persistence.repository;

public interface UserAccountRepository {
	
	String getAllAccounts();

	String createAccount(String useraccount);
	
	String updateAccount(Long userID, String userFullName);

	String deleteAccount(Long userID);

}
