package com.hostelms.service;

import java.util.List;

import com.hostelms.exception.GlobalException;
import com.hostelms.model.User;
import com.hostelms.modeldto.UserDTO;

public interface UserService {

	String login(int userId, String userName, String userPassword) throws GlobalException;

	String addUser(UserDTO user) throws GlobalException;

	String deleteUser(int userId) throws GlobalException;

	User getUserById(int userId) throws GlobalException;

	List<User> getAllUser() throws GlobalException;

	User updateUser(UserDTO user);

	String updateRent(int userId, int userRent) throws GlobalException;

	String updateEmail(int userId, String email) throws GlobalException;

	String updateContact(int userId, String contactNo) throws GlobalException;

	String allotRoom(int roomId, int userId) throws GlobalException;

	List<User> sortUser(String fields);
}
