package com.neorays.command;

public class RegisternCommand {

	private String name;
	private String psw;
	private String email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "RegisternCommand [name=" + name + ", psw=" + psw + ", email="
				+ email + "]";
	}
	
}//class
