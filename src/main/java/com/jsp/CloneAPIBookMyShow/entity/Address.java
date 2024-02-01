	package com.jsp.CloneAPIBookMyShow.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Data
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long address_id;
	private int flat_no;
	private String area;
	private String landmark;
	private String city;
	private String state;
	private String country;
	private long pincode;
	
	@OneToOne(mappedBy = "address")
	@JsonIgnore
	private Theatre theatre;
	
}
