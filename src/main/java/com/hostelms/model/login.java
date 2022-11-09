package com.hostelms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// Settiing a model for login method
public class login {

	// using login name and password to match with user name and password
	private String userName;
	private String userPassword;
}