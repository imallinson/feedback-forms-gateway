package com.qa.Gateway.persistence.domain;

public class Account {
	private Long accountID;
	private Long cohortID;
	private boolean admin;
	private String userName;
	private String email;
	private String password;
	private boolean flagged;
	
	public Account() {
		
	}
	
	public Account(Long cohortID, boolean admin, String userName, String email, String password, boolean flagged) {
		this.cohortID = cohortID;
		this.admin = admin;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.flagged = flagged;
	}

	public Long getAccountID() {
		return accountID;
	}

	public void setAccountID(Long accountID) {
		this.accountID = accountID;
	}

	public Long getCohortID() {
		return cohortID;
	}

	public void setCohortID(Long cohortID) {
		this.cohortID = cohortID;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isFlagged() {
		return flagged;
	}

	public void setFlagged(boolean flagged) {
		this.flagged = flagged;
	}
	

	
}
