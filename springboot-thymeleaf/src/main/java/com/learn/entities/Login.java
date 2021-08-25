package com.learn.entities;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Login {
	@NotBlank(message = "User name can't be empty.")
	@Size(min = 5, max = 10)
	private String userName;
	@NotBlank()
	@Email
	private String email;
	
	@AssertTrue
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
		return "Login [userName=" + userName + ", email=" + email + ", agreed=" + agreed + "]";
	}
	
	
}
