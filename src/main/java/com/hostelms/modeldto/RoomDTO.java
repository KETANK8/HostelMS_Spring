package com.hostelms.modeldto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {

	@NotNull(message = "Room ID cannot be null!!!")
	private int roomId;
	@NotNull(message = "Room Name cannot be null!!!")
	private String roomName;
	@NotNull(message = "Room Type cannot be null!!!")
	private String roomType;

}
