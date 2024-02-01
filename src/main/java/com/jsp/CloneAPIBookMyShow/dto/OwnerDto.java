package com.jsp.CloneAPIBookMyShow.dto;

import java.time.LocalDateTime;

import com.jsp.CloneAPIBookMyShow.enums.BookingStatus;
import com.jsp.CloneAPIBookMyShow.enums.SeatType;

import lombok.Data;

@Data
public class OwnerDto {
	private long owner_id;
	private String owner_name;
	private long owner_phoneno;
	private String owner_email;
	
	
	
}
