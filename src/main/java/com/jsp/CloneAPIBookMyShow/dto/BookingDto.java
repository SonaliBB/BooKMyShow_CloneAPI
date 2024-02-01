package com.jsp.CloneAPIBookMyShow.dto;

import java.time.LocalDateTime;

import com.jsp.CloneAPIBookMyShow.enums.BookingStatus;
import com.jsp.CloneAPIBookMyShow.enums.SeatType;

import lombok.Data;
@Data
public class BookingDto {
	private long booking_id;
	private LocalDateTime booking_from_time;
	private LocalDateTime booking_till_time;
	private long seat_id;
	
	//bookingStatus
	private BookingStatus booking_status;
	private double seat_price;
	
	//SeatType
	private SeatType seat_type;

}
