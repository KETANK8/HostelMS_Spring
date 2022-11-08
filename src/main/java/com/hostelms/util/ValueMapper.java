package com.hostelms.util;

import com.hostelms.model.Room;
import com.hostelms.model.User;
import com.hostelms.modeldto.RoomDTO;
import com.hostelms.modeldto.UserDTO;

public class ValueMapper {

	public static User dataTransferToUser(UserDTO user) {
		User _user = new User(user.getUserId(), user.getUserName(), user.getFirstName(), user.getLastName(),
				user.getUserContact(), user.getUserPassword(), user.getUserEmailAddress(), user.getUserRole(),
				user.getUserRent(), user.getUserRoom());
		return _user;
	}

	public static Room dataTransferToRoom(RoomDTO room) {
		Room _room = new Room(room.getRoomId(), room.getRoomName(), room.getRoomType());
		return _room;
	}

}
