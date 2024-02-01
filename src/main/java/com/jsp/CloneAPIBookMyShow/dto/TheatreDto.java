package com.jsp.CloneAPIBookMyShow.dto;

import java.time.LocalDateTime;

import com.jsp.CloneAPIBookMyShow.enums.BookingStatus;
import com.jsp.CloneAPIBookMyShow.enums.SeatType;

import lombok.Data;

@Data
public class TheatreDto {
	private long theatre_id;
	private String theatre_name;
	
}
