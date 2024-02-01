package com.jsp.CloneAPIBookMyShow.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import com.jsp.CloneAPIBookMyShow.entity.Seat;
import com.jsp.CloneAPIBookMyShow.enums.BookingStatus;
import com.jsp.CloneAPIBookMyShow.enums.ScreenAvailability;
import com.jsp.CloneAPIBookMyShow.enums.ScreenStatus;
import com.jsp.CloneAPIBookMyShow.enums.ScreenType;
import com.jsp.CloneAPIBookMyShow.enums.SeatType;

import lombok.Data;
@Data
public class ScreenDto {
	private long screen_id;
	private String screen_name;

	//screenType
	private ScreenType screen_type;
	//screenVailability
	private ScreenAvailability availability;
	//screenstatus
	private ScreenStatus screen_status;

	private int no_of_classic_seat;
	private int no_of_plantinum_seat;
	private int no_of_gold_seat;
	

}
