package com.jsp.CloneAPIBookMyShow.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AddressDto {
	private long address_id;
	private int flat_no;
	@NotNull(message = "Area can't be null")
	@NotBlank(message = "Area can't be blank")
	private String area;
	@NotNull(message = "landmark  can't be null")
	@NotBlank(message = "landmark can't be blank")
	private String landmark;
	private String city;
	private String state;
	private String country;
	private long pincode;
	
}
