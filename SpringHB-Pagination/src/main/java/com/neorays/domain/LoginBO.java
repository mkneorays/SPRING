package com.neorays.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="LOGIN_EMP")
public class LoginBO {

	private int id;
	private String name;
	private String psw;
	private String email;
	
	@Type(type="string")
	@Column(name="NAME",length=20,nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Type(type="string")
	@Column(name="PASSWORD",length=10,nullable=false)
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	@Type(type="string")
	@Column(name="EMAIL",length=20,nullable=false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Id
	@Column(name="EMP_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "LoginBO [id=" + id + ", name=" + name + ", psw=" + psw + ", email=" + email + "]";
	}
	
}
