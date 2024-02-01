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

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jsp.CloneAPIBookMyShow.enums.Genre;

import lombok.Data;


@Entity
@Data
public class Movie {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long movie_id;
private String movie_name;

//genresss
@Enumerated(EnumType.STRING)  //used if we want enum get converted into spring in database instead of int 
private Genre genre1;
@Enumerated(EnumType.STRING)
private Genre genre2;
@Enumerated(EnumType.STRING)
private Genre genre3;

@DateTimeFormat(style = "HH:mm")
private LocalDateTime movie_duration;
private String movie_description;
private String language;
@ManyToOne
@JsonIgnore
@JoinColumn
private ProductionHouse productionHouse;

}
