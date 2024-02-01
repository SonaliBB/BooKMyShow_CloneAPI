package com.jsp.CloneAPIBookMyShow.dto;

import java.time.LocalDateTime;

import com.jsp.CloneAPIBookMyShow.enums.BookingStatus;
import com.jsp.CloneAPIBookMyShow.enums.SeatType;
import com.jsp.CloneAPIBookMyShow.enums.TicketStatus;

import lombok.Data;
@Data
public class TicketDto {
	private int ticket_id;
	private long total_price;

	//TicketStatus
	private TicketStatus ticket_status;

	
}
