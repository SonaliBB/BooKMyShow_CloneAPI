package com.jsp.CloneAPIBookMyShow.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.jsp.CloneAPIBookMyShow.enums.Genre;
import com.jsp.CloneAPIBookMyShow.enums.ShowStatus;

import lombok.Getter;
import lombok.Setter;

@Entity

@Getter
@Setter
public class Show {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long show_id;
private LocalDateTime show_start_time;
private LocalDateTime show_end_time;

//showstatus
@Enumerated(EnumType.STRING)
private ShowStatus show_status;
private String show_location;

private long movie_id;
private String movie_name;

//genre
@Enumerated(EnumType.STRING)
private Genre genre;

private LocalDateTime movie_duration;
private String movie_description;
private String movie_language;

private long screen_id;
private String screen_name;
private double classic_seat_price;
private double gold_seat_price;
private double premium_seat_price;

@ManyToOne
@JoinColumn
private Theatre theatre;


}
