package org.launchcode.spaday.models;

import javax.validation.constraints.*;

public class User {

	@NotBlank(message = "username cannot be blank")
	@Size(min = 5, max = 15, message = "username must be between 5 and 15 characters")
	private String username;

	@Email
	private String email;

	@Size(min = 6, message = "password must be at least 6 characters")
	@NotBlank(message = "password cannot be blank")
	private String password;

	@NotNull(message = "passwords must match")
	private String verify;

	public User() {

	}

	public User(String username, String email, String password) {
		this();
		this.username = username;
		this.email = email;
		this.password = password;
	}

	private void checkPassword() {
		if (!password.equals(verify) && !(password == null) && !(verify == null)) {
			verify = null;
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {

		this.password = password;
		checkPassword();
	}

	public String getVerify() {
		return verify;
	}

	public void setVerify(String verify) {
		this.verify = verify;
		checkPassword();
	}
}
