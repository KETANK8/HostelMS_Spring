/**
 * HOSTEL   MANAGEMENT    SYSTEM
 * @author Ketan Kumar
 * Illustrating USE OF SPRING BOOT,JPA REPOSITORY, LOMBOK,VALIDATION AND GLOBAL EXCEPTION IN HOSTEL MANAGEMENT SYSTEM 
 * TO CREATE USER,ROOM ADD ROOM AND USER TO DATABASE USING JPA REPOSITORY
 * ALLOTING ROOM TO USER
 * THERE ARE TWO TYPES OF USER
 * ->ADMIN
 * ->END USER
 * AND PRINT DATA OF ONE OR ALL USER USING LOGGER, DELETE USER AND ROOM USING DATA ACCESS OBJECT  
 * CREATING AND USING GLOBAL EXCEPTION
 * ILLUSTRATING OBJECT RELATION MAPPING IN ENTITY 
 * ONE ROOM CAN HAVE MANY USER
 */
package com.hostelms.controller;

import java.util.List;

import com.hostelms.exception.GlobalException;
import com.hostelms.model.Room;
import com.hostelms.model.User;
import com.hostelms.modeldto.RoomDTO;
import com.hostelms.modeldto.UserDTO;
import com.hostelms.service.RoomService;
import com.hostelms.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserService userService;
	@Autowired
	private RoomService roomService;

	// MAPPING METHOD 1
	// TO HANDLE REQUEST TO LOGIN USING USERNAME AND PASSWORD
	@GetMapping("/login/{userId}/{userName}/{userPassword}")
	public ResponseEntity<String> login(@PathVariable int userId, String userName, String userPassword)
			throws GlobalException {
		return new ResponseEntity<>(userService.login(userId, userName, userPassword), HttpStatus.ACCEPTED);
	}

	// MAPPING METHOD 2
	// TO HANDLE REQUEST TO ADD NEW USER
	@PostMapping("/add/user")
	public ResponseEntity<String> addUser(@RequestBody UserDTO user) throws GlobalException {
		String status = userService.addUser(user);
		if (status != null)
			return new ResponseEntity<>(status, HttpStatus.CREATED);
		else
			return new ResponseEntity<>(status, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// MAPPING METHOD 3
	// HANDLE REQUEST TO FETCH ALL USER FROM DATABASE
	@GetMapping("/fetch/all/user")
	public ResponseEntity<List<User>> getAllUser() throws GlobalException {
		return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
	}

	// MAPPING METHOD 4
	// HANDLE REQUEST TO FETCH USER FROM DATABASE USING PRIMARY KEY
	@GetMapping("/fetch/user/id/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable int userId) throws GlobalException {
		return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.ACCEPTED);
	}

	// MAPPING METHOD 5
	// HANDLE REQUEST TO SORT THE USER LIST BASED ON DIFFERNT COLOUMN IN DATABASE
	@GetMapping("/sort/user/{fields}")
	public ResponseEntity<List<User>> sortUser(@PathVariable String fields) {
		return new ResponseEntity<>(userService.sortUser(fields), HttpStatus.ACCEPTED);
	}

	// MAPPING METHOD 6
	// HANDLE REQUEST TO UPDATE THE DETAILS OF EXISTING USER IN DATABASE
	@PutMapping("/update/user")
	public ResponseEntity<User> updateUser(@RequestBody UserDTO user) {
		return new ResponseEntity<>(userService.updateUser(user), HttpStatus.ACCEPTED);
	}

	// MAPPING METHOD 7
	// HANDLE REQUEST TO UPDATE OR SET THE RENT AMOUNT OF AN USER IN DATABASE
	@PutMapping("/update/user/rent/{userId}/{userRent}")
	public ResponseEntity<String> updateUserRent(@PathVariable int userId, int userRent) throws GlobalException {
		return new ResponseEntity<>(userService.updateRent(userId, userRent), HttpStatus.ACCEPTED);
	}

	// MAPPING METHOD 8
	// HANDLE REQUEST TO CHANGE AND UPDATE THE EMAIL ADDRESS OF AN USER IN DATABASE
	@PutMapping("/update/user/email/{userId}/{email}")
	public ResponseEntity<String> updateUserEmail(@PathVariable int userId, String email) throws GlobalException {
		return new ResponseEntity<>(userService.updateEmail(userId, email), HttpStatus.ACCEPTED);
	}

	// MAPPING METHOD 9
	// HANDLE REQUEST TO CHANGE AND UPDATE THE CONTACT INFO OF AN USER
	@PutMapping("/update/user/contact/{userId}/{contact}")
	public ResponseEntity<String> updateContact(@PathVariable int userId, String contact) throws GlobalException {
		return new ResponseEntity<>(userService.updateContact(userId, contact), HttpStatus.ACCEPTED);
	}

	// MAPPING METHOD 10
	// HANDLE REQUEST TO ALLOT A ROOM TO THE USER
	@PutMapping("/allot/room/{roomId}/{userId}")
	public ResponseEntity<String> allotUserRoom(@PathVariable int roomId, int userId) throws GlobalException {
		return new ResponseEntity<>(userService.allotRoom(roomId, userId), HttpStatus.ACCEPTED);
	}

	// MAPPING METHOD 11
	// HANDLE REQUEST TO DELETE AN USER FROM DATABASE USING PRIMARY KEY
	@DeleteMapping("/delete/user/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable int userId) throws GlobalException {
		return new ResponseEntity<>(userService.deleteUser(userId), HttpStatus.OK);
	}

	// MAPPING METHOD 12
	// HANDLE THE REQUEST TO ADD NEW ROOM IN DATABASE
	@PostMapping("/add/room")
	public ResponseEntity<String> addUser(@RequestBody RoomDTO room) throws GlobalException {
		String status = roomService.addRoom(room);
		if (status != null)
			return new ResponseEntity<>(status, HttpStatus.CREATED);
		else
			return new ResponseEntity<>(status, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// MAPPING METHOD 13
	// HANDLE THE REQUEST TO FETCH LIST OF ALL ROOM IN DATABASE
	@GetMapping("/fetch/all/room")
	public ResponseEntity<List<Room>> getAllRoom() throws GlobalException {
		return new ResponseEntity<>(roomService.getAllRoom(), HttpStatus.OK);
	}

	// MAPPING METHOD 14
	// HANDLE THE REQUEST TO FETCH A ROOM DETAIL USING PRIMARY KEY
	@GetMapping("/fetch/room/id/{roomId}")
	public ResponseEntity<Room> getRoomById(@PathVariable int roomId) throws GlobalException {
		return new ResponseEntity<>(roomService.getRoomById(roomId), HttpStatus.OK);
	}

	// MAPPING METHOD 15
	// HANDLE THE REQUEST TO DELETE A ROOM FROM DATABASE USING PRIMARY KEY
	@DeleteMapping("/delete/room/{roomId}")
	public ResponseEntity<String> deleteRoom(@PathVariable int roomId) throws GlobalException {
		return new ResponseEntity<>(roomService.deleteRoom(roomId), HttpStatus.OK);
	}
}
