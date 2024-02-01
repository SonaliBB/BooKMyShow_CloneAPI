package com.jsp.CloneAPIBookMyShow.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
@Entity
@Data
public class ProductionHouse {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long production_id;
	private String production_name;
	private LocalDate establishment;
	@ManyToOne
	@JoinColumn
	private Owner owner;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "productionHouse")
	private List<Movie> movies;

	
}
