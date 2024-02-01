package com.jsp.CloneAPIBookMyShow.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.jsp.CloneAPIBookMyShow.enums.BookingStatus;
import com.jsp.CloneAPIBookMyShow.enums.Genre;
import com.jsp.CloneAPIBookMyShow.enums.SeatType;

import lombok.Data;

@Data
public class MovieDto {
	private long movie_id;
	private String movie_name;
	//genresss
	private Genre genre1;
	private Genre genre2;
	private Genre genre3;
	@DateTimeFormat(style = "HH:mm")
	private LocalTime movie_duration;
	private String movie_description;
	private String language;
	
}
