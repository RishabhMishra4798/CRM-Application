package com.marketingapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "leads")
public class Lead {
	@Id //Used for primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //For auto generated
	private long id;
	
	@Column(name="firstName", length=45, nullable=false)
	private String firstName;
	
	@Column(name="lastName", length=45, nullable=false)
	private String lastName;
	
	@Column(unique=true, nullable=false)
	private String email;
	
	@Column(length=10, unique= true, nullable=false)
	private long mobile;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	
	
}
