package com.jsp.CloneAPIBookMyShow.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.CloneAPIBookMyShow.dao.CustomerDao;
import com.jsp.CloneAPIBookMyShow.dto.CustomerDto;
import com.jsp.CloneAPIBookMyShow.entity.Customer;
import com.jsp.CloneAPIBookMyShow.exception.CustomerIdNotFoundException;
import com.jsp.CloneAPIBookMyShow.util.ResponseStructure;

@Service
public class CustomerService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CustomerDao customerDao;
	
	ResponseStructure<CustomerDto> responseStructure=new  ResponseStructure<>();
	
	public ResponseEntity<ResponseStructure<CustomerDto>> saveCustomer(Customer customer) {
		Customer dbCustomer=customerDao.saveCustomer(customer);
		CustomerDto customerDto=this.modelMapper.map(dbCustomer, CustomerDto.class);
			responseStructure.setMessage("Customer data saved successfully");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(customerDto);
			return new ResponseEntity<ResponseStructure<CustomerDto>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<CustomerDto>> updateCustomer(Customer customer,long customerId) {
		Customer dbCustomer=customerDao.updateCustomer(customerId, customer);
		if (dbCustomer!=null) {
			responseStructure.setMessage("Customer data updated successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dbCustomer);
			return new ResponseEntity<ResponseStructure<CustomerDto>>(responseStructure,HttpStatus.OK);		
		}
		throw new CustomerIdNotFoundException("Customer Id not found");
	}
	
	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(long customerId) {
		Customer customer=customerDao.getCustomerById(customerId);
		if (customer!=null) {
			ResponseStructure<Customer> responseStructure=new  ResponseStructure<>();
			responseStructure.setMessage("Customer data fetched successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(customer);
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure,HttpStatus.FOUND);		
		}
		throw new CustomerIdNotFoundException("Customer Id not found");
	}
	
	public ResponseEntity<ResponseStructure<Customer>>  deleteCustomerById(long customerId) {
		Customer customer=customerDao.deleteCustomer(customerId);
		if (customer!=null) {
			ResponseStructure<Customer> responseStructure=new  ResponseStructure<>();
			responseStructure.setMessage("Customer data deleted successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(customer);
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure,HttpStatus.OK);		
		}
		throw new CustomerIdNotFoundException("Customer Id not found");
	}
}
