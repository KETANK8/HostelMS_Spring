package com.hostelms.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.hostelms.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserId(int userId);

	@Transactional
	@Modifying
	@Query(value = "update User set user_rent =: userRent where user_id =: userId")
	int updateUserRent(int userId, int userRent);

	@Query(value = "from User where user_room_room_id=:roomId")
	List<User> roomStatus(int roomId);

	@Transactional
	@Modifying
	@Query(value = "update User set user_room_room_id=:roomId where user_id=:userId")
	int allotUserRoom(int roomId, int userId);

	@Transactional
	@Modifying
	@Query(value = "update User set user_email_address =: email where user_id =: userId")
	int updateUserEmail(int userId, String email);

	@Transactional
	@Modifying
	@Query(value = "update User set user_contact =: contactNo where user_id =: userId")
	int updateUserContact(int userId, String contactNo);

}
