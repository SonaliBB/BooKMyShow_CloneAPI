package com.jsp.CloneAPIBookMyShow.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.CloneAPIBookMyShow.entity.Customer;
import com.jsp.CloneAPIBookMyShow.repository.CustomerRepo;

@Repository
public class CustomerDao {

	@Autowired
	private CustomerRepo customerRepo;
	
	public Customer saveCustomer(Customer customer) {
		return customerRepo.save(customer);
	}
	
	public Customer  updateCustomer(long customerId,Customer customer) {
		Optional<Customer> optional=customerRepo.findById(customerId);
		if (optional.isPresent()) {
			customer.setCustomer_id(customerId);
			customerRepo.save(customer);
			return customer;
		}
		return null;
	}
	
	public Customer  deleteCustomer(long customerId) {
		Optional<Customer> optional=customerRepo.findById(customerId);
		if (optional.isPresent()) {
			 customerRepo.delete(optional.get());
			 return optional.get();
		}
		return null;
	}
	
	public Customer getCustomerById(long customerId) {
		Optional<Customer> optional=customerRepo.findById(customerId);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
}
