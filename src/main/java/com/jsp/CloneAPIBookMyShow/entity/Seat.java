package com.jsp.CloneAPIBookMyShow.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jsp.CloneAPIBookMyShow.enums.SeatType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long seat_id;
	
	//seattype
    
    @Enumerated(EnumType.STRING)
    @Column(name="seat_type")
     private SeatType seat_type;

	@ManyToOne
	@JsonIgnore
	@JoinColumn
	private Screen screen;
	
}
