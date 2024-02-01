package com.jsp.CloneAPIBookMyShow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.CloneAPIBookMyShow.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

	Optional<Customer> findById(long customerId);

}
