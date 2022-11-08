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
import com.hostelms.model.Room;
import com.hostelms.modeldto.RoomDTO;
import com.hostelms.repository.RoomRepository;
import com.hostelms.service.RoomService;
import com.hostelms.util.ValueMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomRepository roomRepo;

	// METHOD 1
	// ADD NEW ROOM IN DATABASE
	@Override
	public String addRoom(RoomDTO room) {
		// TODO Auto-generated method stub
		Room _room = ValueMapper.dataTransferToRoom(room);
		roomRepo.save(_room);
		return "Room added";
	}

	// METHOD 2
	// DELETE A ROOM USING PRIMARY KEY
	@Override
	public String deleteRoom(int roomId) throws GlobalException {
		// TODO Auto-generated method stub
		Room _room = roomRepo.findByRoomId(roomId);
		if (_room != null) {
			roomRepo.deleteById(roomId);
			return _room.getRoomName() + " Deleted";
		} else
			throw new GlobalException("Room not found!!!");
	}

	// METHOD 3
	// FETCH A ROOM DETAILS USING PRIMARY KEY
	@Override
	public Room getRoomById(int roomId) throws GlobalException {
		// TODO Auto-generated method stub
		Room _room = roomRepo.findByRoomId(roomId);
		if (_room != null)
			return _room;
		else
			throw new GlobalException("Room not found!!!");
	}

	// METHOD 4
	// FETCH LIST OF ALL ROOM IN DATABASE
	@Override
	public List<Room> getAllRoom() throws GlobalException {
		// TODO Auto-generated method stub
		List<Room> _roomList = roomRepo.findAll();
		if (_roomList.isEmpty())
			throw new GlobalException("Table is empty \nNo Room Exist!!!");
		else
			return _roomList;
	}

}
