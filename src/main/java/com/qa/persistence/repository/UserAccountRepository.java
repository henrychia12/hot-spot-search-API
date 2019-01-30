package com.qa.persistence.repository;

public interface UserAccountRepository {
	
	String getAllAccounts();

	String createAccount(String userAccount);
	
	String updateAccount(Long userID, String userAccount);

	String deleteAccount(Long userID);

}
