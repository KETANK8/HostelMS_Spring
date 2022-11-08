package com.hostelms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column(length = 30)
	private String userName;
	@Column(length = 20)
	private String firstName;
	@Column(length = 20)
	private String lastName;
	@Column(length = 15)
	private String userContact;
	@Column(length = 30)
	private String userPassword;
	@Column(length = 50)
	private String userEmailAddress;
	@Column(length = 20)
	private String userRole;
	private int userRent;

	@ManyToOne
	private Room userRoom;

}
