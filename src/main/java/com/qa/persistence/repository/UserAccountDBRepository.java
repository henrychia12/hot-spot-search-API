package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.UserAccount;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default

public class UserAccountDBRepository implements UserAccountRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;

	public String getAllAccounts() {
		Query query = manager.createQuery("Select a FROM Account a");
		Collection<UserAccount> userAccounts = (Collection<UserAccount>) query.getResultList();
		return util.getJSONForObject(userAccounts);
	}

	@Transactional(REQUIRED)
	public String createAccount(String userAccount) {
		UserAccount newUserAccount = util.getObjectForJSON(userAccount, UserAccount.class);
		manager.persist(newUserAccount);
		return "{\"message\": \"User account has been sucessfully created\"}";
	}
	
	@Transactional(REQUIRED)
	public String updateAccount(Long userID, String userFullName) {
		UserAccount userAccountInDB = findUserAccount(userID);
		UserAccount newUserAccount = util.getObjectForJSON(userFullName, UserAccount.class);
		if(userAccountInDB != null) {
			manager.remove(userAccountInDB);
			manager.persist(newUserAccount);
			return "{\"message\": \"has been sucessfully updated\"}";
		}
		return"{\"message\": \"details entered are invalid\"}";
	}

	@Transactional(REQUIRED)
	public String deleteAccount(Long userID) {
		UserAccount userAccountInDB = findUserAccount(userID);
		if(userAccountInDB != null) {
			manager.remove(userAccountInDB);
			return "{\"message\": \"user account sucessfully deleted\"}";
		}
		return "{\"message\": \"deletion unsuccessful\"}";
	}
	
	private UserAccount findUserAccount(Long userID) {
		return manager.find(UserAccount.class, userID);
	}
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
	public void setUtil(JSONUtil util) {
		this.util = util;
	}
	

}
