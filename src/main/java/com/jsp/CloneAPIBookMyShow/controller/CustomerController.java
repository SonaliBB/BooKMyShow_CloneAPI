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

import com.jsp.CloneAPIBookMyShow.dto.CustomerDto;
import com.jsp.CloneAPIBookMyShow.entity.Customer;
import com.jsp.CloneAPIBookMyShow.service.CustomerService;
import com.jsp.CloneAPIBookMyShow.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/customer")		
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@ApiOperation(value = "save customer" ,notes = "api used to save customer")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "customer saved successfully"),@ApiResponse(code = 404,message = "customer does not saved,please enter the valid details")})
	
	@PostMapping
	public ResponseEntity<ResponseStructure<CustomerDto>> saveCustomer(@RequestBody Customer customer) {
	return customerService.saveCustomer(customer);	
	}
	
	@ApiOperation(value = "update customer" ,notes = "api used to update customer")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "customer update successfully"),@ApiResponse(code = 404,message = "customer does not updated,please enter the valid details")})
	
	@PutMapping
	public ResponseEntity<ResponseStructure<CustomerDto>> updateCustomer( @RequestBody Customer customer,@RequestParam long customerId) {
	return customerService.updateCustomer(customer,customerId);	
	}
	
	@ApiOperation(value = "get customer" ,notes = "api is used to get the customer details")
	@ApiResponses(value = {@ApiResponse(code = 301,message = "customer data fetched"),@ApiResponse(code = 404,message = "customer diden't fetched,please enter valid details")})
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(@RequestParam long customerId){
		return customerService.getCustomerById(customerId);
	}
	
	@ApiOperation(value = "delete customer" ,notes = "api is used to delete customer details")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "customer data delete"),@ApiResponse(code = 404,message = "customer diden't deleted,please enter valid details")})
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Customer>>  deleteCustomerById(@RequestParam long customerId) {
		return customerService.deleteCustomerById(customerId);
	}
}
