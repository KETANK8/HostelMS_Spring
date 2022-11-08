package com.hostelms.modeldto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.hostelms.model.Room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private int userId;
	// Using Regular Expression
	// RegEx To Check Validation
	// Giving Condition to Set Unique UserName
	@NotNull
	@Pattern(regexp = "[a-zA-Z]{5,20}", message = "\nUserName should Atleast have Five Characters.")
	private String userName;

	@NotNull(message = "First Name cannot be null!!!")
	private String firstName;
	@NotNull(message = "Last Name cannot be null!!!")
	private String lastName;

	// Using Regular Expression
	// RegEx To Check Validation
	// Giving Condition to Set Contact Number
	@NotNull
	@Pattern(regexp = "[0-9]{9,15}", message = "\nContact No should Atleast have 10 digits.")
	private String userContact;

	// Using Regular Expression
	// RegEx To Check Validation
	// Giving Condition to Set Unique Password
	@NotNull
	@Pattern(regexp = "[a-zA-Z0-9_@#]{8,30}", message = "\nPassword can be AlphaNumeric and Atleast have 8 Characters.\n(Use atleast 1 Upper Case, 1 Lower Case, 1 Number)")
	private String userPassword;
	@Email
	private String userEmailAddress;
	private String userRole;
	private int userRent;

	private Room userRoom;
}
