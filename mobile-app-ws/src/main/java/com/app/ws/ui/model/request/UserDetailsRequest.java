package com.app.ws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserDetailsRequest {
	@NotEmpty(message = "enter name")
	@Size(min = 2,message = "name letnth is more than 2",max = 5)
	private String firstname;
	
	@NotEmpty(message = "not empty last name")
	private String lastname;
	
	@Email
	private String emil;
	
	@NotEmpty(message = "not empty")
	@Size(min = 1,max = 5,message = "lenth less than 5")
	private String userid;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmil() {
		return emil;
	}

	public void setEmil(String emil) {
		this.emil = emil;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}