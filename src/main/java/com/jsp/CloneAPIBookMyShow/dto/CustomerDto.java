package com.jsp.CloneAPIBookMyShow.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.jsp.CloneAPIBookMyShow.enums.BookingStatus;
import com.jsp.CloneAPIBookMyShow.enums.SeatType;

import lombok.Data;
@Data
public class CustomerDto {
	private long customer_id;
	private String customer_name;
//	@Min(600000001)
//	@Max(999999999)
	private long customer_phone;
	private String customer_email;
	
	
}
