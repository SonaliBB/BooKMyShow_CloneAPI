package com.jsp.CloneAPIBookMyShow.dto;

import java.time.LocalDateTime;

import com.jsp.CloneAPIBookMyShow.enums.BookingStatus;
import com.jsp.CloneAPIBookMyShow.enums.SeatType;

import lombok.Data;
@Data
public class SeatDto {
private int seat_id;
	
	//seattype
     private SeatType seat_type;

	
}
