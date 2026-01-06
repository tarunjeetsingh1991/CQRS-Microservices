package com.practice.entities;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Form_Data")
public class LoginData {

	@Id
	@Column(name="userName")
	@NotBlank(message = "User Name can not be empty !!")
	@Size(min = 3, max = 12, message = "User name must be between 3 - 12 characters !!")
	private String userName;

	@Column(name="userEmail")
	@Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
	private String email;
	
	@AssertTrue(message = "Must agree terms and condition !!")
	private boolean agreed;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public boolean isAgreed() {
		return agreed;
	}

	public void setAgreed(boolean agreed) {
		this.agreed = agreed;
	}

	@Override
	public String toString() {
		return "LoginData [userName=" + userName + ", email=" + email + "]";
	}

}
