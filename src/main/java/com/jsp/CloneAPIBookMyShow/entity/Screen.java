package com.jsp.CloneAPIBookMyShow.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.jsp.CloneAPIBookMyShow.enums.ScreenAvailability;
import com.jsp.CloneAPIBookMyShow.enums.ScreenStatus;
import com.jsp.CloneAPIBookMyShow.enums.ScreenType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Screen {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private long screen_id;
private String screen_name;

//screenType
@Enumerated(EnumType.STRING)
private ScreenType screen_type;
//screenVailability
@Enumerated(EnumType.STRING)
private ScreenAvailability availability;
//screenstatus
@Enumerated(EnumType.STRING)
private ScreenStatus screen_status;

@OneToMany(mappedBy = "screen" ,cascade = CascadeType.ALL)
private List<Seat> seats;
private int no_of_classic_seat;
private int no_of_plantinum_seat;
private int no_of_gold_seat;

@ManyToOne
@JoinColumn
private Theatre theatre;

}
