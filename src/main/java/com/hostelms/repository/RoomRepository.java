package com.hostelms.repository;

import com.hostelms.model.Room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

	Room findByRoomId(int roomId);

}