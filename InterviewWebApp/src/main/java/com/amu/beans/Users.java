package com.amu.beans;

public class Users {

	private String userId;
	private String name;
	private String pass;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", name=" + name + ", pass=" + pass + "]";
	}

}
