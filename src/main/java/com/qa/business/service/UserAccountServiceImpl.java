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

	public String createAccount(String userAccount) {
		if ((util.getObjectForJSON(userAccount, UserAccount.class).getUserFullName() == "Henry Chia")) {
			return "{\"message\": \"User is banned\"}";
		}
		return repo.createAccount(userAccount);
	}

	public String updateAccount(Long userID, String userFullName) {
		return repo.updateAccount(userID, userFullName);
	}

	public String deleteAccount(Long userID) {
		return repo.deleteAccount(userID);
	}

	public void setRepo(UserAccountRepository repo) {
		this.repo = repo;
	}

}
