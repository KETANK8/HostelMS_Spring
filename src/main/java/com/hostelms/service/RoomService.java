package com.hostelms.service;

import java.util.List;

import com.hostelms.exception.GlobalException;
import com.hostelms.model.Room;
import com.hostelms.modeldto.RoomDTO;

public interface RoomService {

	String addRoom(RoomDTO room);

	String deleteRoom(int roomId) throws GlobalException;

	Room getRoomById(int roomId) throws GlobalException;

	List<Room> getAllRoom() throws GlobalException;
}
