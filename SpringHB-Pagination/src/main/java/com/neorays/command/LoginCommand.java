package com.neorays.command;

public class LoginCommand {

	private String name;
	private String psw;
	
	public String getUser() {
		return name;
	}
	public void setUser(String user) {
		this.name = user;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	@Override
	public String toString() {
		return "LoginCommand [name=" + name + ", psw=" + psw + "]";
	}
	
	
}
