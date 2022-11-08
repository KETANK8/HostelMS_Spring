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
package com.hostelms.serviceimpl;

import java.util.List;

import com.hostelms.exception.GlobalException;
import com.hostelms.model.User;
import com.hostelms.modeldto.UserDTO;
import com.hostelms.repository.UserRepository;
import com.hostelms.service.UserService;
import com.hostelms.util.ValueMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	// METHOD 1
	// ADD NEW USER IN DATABASE
	@Override
	public String addUser(UserDTO user) throws GlobalException {
		// TODO Auto-generated method stub
		User _user = userRepo.findByUserId(user.getUserId());
		if (_user != null)
			throw new GlobalException("User Already Exist!!!");
		else {
			_user = ValueMapper.dataTransferToUser(user);
			userRepo.save(_user);
		}
		return _user.getFirstName() + " " + _user.getLastName() + " added.";
	}

	// METHOD 2
	// DELETE USER FORM DATABASE
	@Override
	public String deleteUser(int userId) throws GlobalException {
		// TODO Auto-generated method stub
		User _user = userRepo.findByUserId(userId);
		if (_user != null) {
			userRepo.deleteById(userId);
			return _user.getFirstName() + " " + _user.getLastName() + " deleted.";
		} else
			throw new GlobalException("User does not exist.");
	}

	// METHOD 3
	// FETCH USER DETAILS
	@Override
	public User getUserById(int userId) throws GlobalException {
		// TODO Auto-generated method stub
		User _user = userRepo.findByUserId(userId);
		if (_user != null)
			return _user;
		else
			throw new GlobalException("User does not exist");
	}

	// METHOD 4
	// FETCH LIST OF ALL USER
	@Override
	public List<User> getAllUser() throws GlobalException {
		// TODO Auto-generated method stub
		List<User> _userList = userRepo.findAll();
		if (_userList.isEmpty())
			throw new GlobalException("Empty Table");
		return _userList;
	}

	// METHOD 5
	// UPDATE THE DETAILS OF AN USER IN DB
	@Override
	public User updateUser(UserDTO user) {
		// TODO Auto-generated method stub
		User _user = ValueMapper.dataTransferToUser(user);
		return userRepo.save(_user);
	}

	// METHOD 6
	// SORT USER LIST BASED ON DIFFERENT CRITERIA
	@Override
	public List<User> sortUser(String fields) {
		// TODO Auto-generated method stub
		return userRepo.findAll(Sort.by(Direction.DESC, fields));
	}

	// METHOD 7
	// UPDATE THE RENT AMOUNT OF AN USER
	@Override
	public String updateRent(int userId, int userRent) throws GlobalException {
		// TODO Auto-generated method stub
		User _user = userRepo.findByUserId(userId);
		if (_user != null) {
			int status = userRepo.updateUserRent(userId, userRent);
			return "Rent Updated";
		} else
			throw new GlobalException("User not found!!!");
	}

	// METHOD 8
	// ALLOT A ROOM TO USER
	@Override
	public String allotRoom(int roomId, int userId) throws GlobalException {
		// TODO Auto-generated method stub
		List<User> _userList = userRepo.roomStatus(roomId);
		if (_userList.size() < 4) {
			userRepo.allotUserRoom(roomId, userId);
			User _user = userRepo.findByUserId(userId);
			return roomId + " Room Alloted to User " + _user.getFirstName() + " " + _user.getLastName();
		} else
			throw new GlobalException("Room is already full!!!");
	}

	// METHOD 9
	// LOGIN USING USERNAME AND PASSWORD MATCHING
	@Override
	public String login(int userId, String userName, String userPassword) throws GlobalException {
		// TODO Auto-generated method stub
		User _user = userRepo.findByUserId(userId);
		if (_user != null)
			if (_user.getUserName().equals(userName))
				if (_user.getUserPassword().equals(userPassword))
					return "Login Successfull. \nWelcome " + _user.getFirstName() + " " + _user.getLastName();
				else
					throw new GlobalException("Wrong Password!!!");
			else
				throw new GlobalException("Wrong Username!!!");
		else
			throw new GlobalException("User not found!!!");
	}

	// METHOD 10
	// CHANGE THE EMAIL ADDRESS OF AN USER
	@Override
	public String updateEmail(int userId, String email) throws GlobalException {
		// TODO Auto-generated method stub
		User _user = userRepo.findByUserId(userId);
		if (_user != null) {
			int status = userRepo.updateUserEmail(userId, email);
			return "Email Updated";
		} else
			throw new GlobalException("User not found!!!");
	}

	// METHOD 11
	// CHANGE THE CONTACT NO OF AN USER IN DATABASE
	@Override
	public String updateContact(int userId, String contactNo) throws GlobalException {
		// TODO Auto-generated method stub
		User _user = userRepo.findByUserId(userId);
		if (_user != null) {
			int status = userRepo.updateUserContact(userId, contactNo);
			return "Phone no Updated";
		} else
			throw new GlobalException("User not found!!!");
	}

}
