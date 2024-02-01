package com.jsp.CloneAPIBookMyShow.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Theatre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long theatre_id;
	private String theatre_name;
	
	@OneToOne
	@JoinColumn
	private Address address;
	
	@OneToMany(cascade = CascadeType.REMOVE,mappedBy = "theatre")
	private List<Screen> screen;
	
	@ManyToOne
	@JoinColumn
	private Owner owner;
	
	@OneToMany(mappedBy = "theatre")
	private List<Show> shows;

}
