package com.sdstc.model;

public class User {
	private String id;
	private String account;
	private String password;
	private String salt;

	public User() {

	}

	public User(String account, String password, String salt) {
		this.account = account;
		this.password = password;
		this.salt = salt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

}
