package com.neorays.command;

public class EmpInsertCommand {

	private int eid;
	private String ename;
	private int eage;
	private String address;
	private long mobile;
	private String location;
	private String designation;
	private String email;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getEage() {
		return eage;
	}
	public void setEage(int eage) {
		this.eage = eage;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	/*@Override
	public String toString() {
		return "EmpInsertCommand [eid=" + eid + ", ename=" + ename + ", eage="
				+ eage + ", address=" + address + ", mobile=" + mobile
				+ ", location=" + location + ", designation=" + designation
				+ ", email=" + email + "]";
	}*/
	
}
