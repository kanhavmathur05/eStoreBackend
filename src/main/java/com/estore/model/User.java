package com.estore.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
public class User implements Serializable
{
@Id
@GeneratedValue
private int userID;

private String userName;
private String password;
private boolean enabled;
private int customerID;

public int getUserID() {
	return userID;
}
public void setUserID(int userID) {
	this.userID=userID;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName=userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password=password;
}
public boolean isEnabled() {
	return enabled;
}
public void setEnabled(boolean enabled) {
	this.enabled=enabled;
}
public int getCustomerID() {
	return customerID;
}
public void setCustomerID(int customerID) {
	this.customerID=customerID;
}
}
