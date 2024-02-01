package com.jsp.CloneAPIBookMyShow.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long owner_id;
	private String owner_name;
	private long owner_phoneno;
	private String owner_email;
	private String owner_password;
	
	@OneToMany(mappedBy = "owner")
	@JsonIgnore
	private List<ProductionHouse> house;
	
	@OneToMany(mappedBy = "owner")
	@JsonIgnore
	private List<Theatre> theatres;


}
