package com.hostelms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Room {

	@Id
	private int roomId;
	@Column(length = 30)
	private String roomName;
	@Column(length = 30)
	private String roomType;

}
