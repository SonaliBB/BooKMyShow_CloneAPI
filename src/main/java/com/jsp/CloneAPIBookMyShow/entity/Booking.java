package com.jsp.CloneAPIBookMyShow.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.jsp.CloneAPIBookMyShow.enums.BookingStatus;
import com.jsp.CloneAPIBookMyShow.enums.SeatType;

import lombok.Data;

@Entity
@Data
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long booking_id;
	private LocalDateTime booking_from_time;
	private LocalDateTime booking_till_time;
	private long seat_id;
	
	//SeatType
	@Enumerated(EnumType.STRING)
	private SeatType seat_type;
	//bookingStatus
	@Enumerated(EnumType.STRING)
		private BookingStatus booking_status;
		private double seatprice;

	
	
	
}
	