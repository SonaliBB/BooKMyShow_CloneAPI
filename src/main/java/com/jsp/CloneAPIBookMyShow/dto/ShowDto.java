package com.jsp.CloneAPIBookMyShow.dto;

import java.time.LocalDateTime;

import com.jsp.CloneAPIBookMyShow.enums.BookingStatus;
import com.jsp.CloneAPIBookMyShow.enums.Genre;
import com.jsp.CloneAPIBookMyShow.enums.SeatType;
import com.jsp.CloneAPIBookMyShow.enums.ShowStatus;

import lombok.Data;
@Data
public class ShowDto {
	private long show_id;
	private LocalDateTime show_start_time;
	private LocalDateTime show_end_time;

	//showstatus
	private ShowStatus show_status;
	private String show_location;

	private long movie_id;
	private String movie_name;

	//genre
	private Genre genre;

	private LocalDateTime movie_duration;
	private String movie_description;
	private String movie_language;

	private long screen_id;
	private String screen_name;
	private double classic_seat_price;
	private double gold_seat_price;
	private double premium_seat_price;
	
}
