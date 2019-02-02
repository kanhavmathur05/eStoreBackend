package com.estore.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity	
public class Authorities implements Serializable
{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int authorityID;
	
	private String role;
	private String userName;
	
	public int getAuthorityID() {
		return authorityID;
	}
	public void setAuthorityID(int authorityID) {
		this.authorityID=authorityID;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role=role;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName=userName;
	}
	
}
