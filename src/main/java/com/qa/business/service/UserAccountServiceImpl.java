package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.UserAccount;
import com.qa.persistence.repository.UserAccountRepository;
import com.qa.util.JSONUtil;

public class UserAccountServiceImpl implements UserAccountService {

	@Inject
	private UserAccountRepository repo;
	@Inject
	private JSONUtil util;

	public String getAllAccounts() {
		return repo.getAllAccounts();
	}
	
	@Override
	public String createAccount(String userAccount) {
		if ((util.getObjectForJSON(userAccount, UserAccount.class).getEmailAddress().equals("henry@gmail.com"))) {
			return "{\"message\": \"User is prohibited from creating an account. Banned user.\"}";
		}
		return repo.createAccount(userAccount);
	}
	
	@Override
	public String updateAccount(Long userID, String userAccount) {
		return repo.updateAccount(userID, userAccount);
	}

	@Override
	public String deleteAccount(Long userID) {
		return repo.deleteAccount(userID);
	}

	public void setRepo(UserAccountRepository repo) {
		this.repo = repo;
	}

}
