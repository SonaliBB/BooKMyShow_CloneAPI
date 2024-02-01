package com.jsp.CloneAPIBookMyShow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.CloneAPIBookMyShow.dto.AddressDto;
import com.jsp.CloneAPIBookMyShow.entity.Address;
import com.jsp.CloneAPIBookMyShow.service.AddressService;
import com.jsp.CloneAPIBookMyShow.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@ApiOperation(value = "save address",notes = "api is used to save address")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "address saved successfully"),@ApiResponse(code = 404,message = "Address not saved ,please enter valid details")})
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody  AddressDto addressDto) {
	return addressService.saveAddress(addressDto);	
	}
	
	@ApiOperation(value = " update address",notes = "api is used to update address")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "address update successfully"),@ApiResponse(code = 404,message = "Address not updated ,please enter valid details")})
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestBody AddressDto addressDto,@RequestParam long addressId	){
		return addressService.updateAddress(addressDto, addressId);
	}
	
	@ApiOperation(value = "get address",notes = "api is used to get the address")
	@ApiResponses(value = {@ApiResponse(code = 301,message = "address fetched successfully"),@ApiResponse(code = 404,message = "Address not fetched ,please enter valid details")})
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Address>> getAddressById(@RequestParam long addressId) {
		return addressService.getAddressById(addressId);
	}
	
	@ApiOperation(value = " delete address",notes = "api is used to delete address")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "address delete successfully"),@ApiResponse(code = 404,message = "Address not deleted ,please enter valid details")})
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(@RequestParam long addressId) {
		return addressService.deleteAddressById(addressId);
	}
}
