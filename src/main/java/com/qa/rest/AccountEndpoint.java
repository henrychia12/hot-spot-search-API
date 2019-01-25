package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.qa.business.service.UserAccountService;

@Path("/userAccount")
public class AccountEndpoint {
	
	@Inject
	private UserAccountService service;

	@Path("/getAllAccounts")
	@GET
	@Produces({ "application/json" })
	public String getAllAccounts() {
//		http://localhost:8080/AccountProject/api/account/getAllAccounts
		return service.getAllAccounts();
	}

	@Path("/createAccount")
	@POST
	@Produces({ "application/json" })
	public String createAccount(String userAccount) {
//		http://localhost:8080/AccountProject/api/account/createAccount
		return service.createAccount(userAccount);
	}

	@Path("/deleteAccount/{userID}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("userID") Long userID) {
//		http://localhost:8080/AccountProject/api/account/deleteAccount/1
		return service.deleteAccount(userID);
	}
	
	@Path("/updateAccount/{userID}")
	@POST
	@Produces({ "application/json" })
	public String updateAccount(@PathParam("userID") Long userID,String userFullName) {
//		http://localhost:8080/AccountProject/api/account/updateAccount/3
		return service.updateAccount(userID,userFullName);
	}

	public void setService(UserAccountService service) {
		this.service = service;
	}

}
