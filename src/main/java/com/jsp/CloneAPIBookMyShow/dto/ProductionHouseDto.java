package com.jsp.CloneAPIBookMyShow.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.jsp.CloneAPIBookMyShow.enums.BookingStatus;
import com.jsp.CloneAPIBookMyShow.enums.SeatType;

import lombok.Data;
@Data
public class ProductionHouseDto {
	private long production_id;
	private String production_name;
	private LocalDate establishment;
	
	
}
