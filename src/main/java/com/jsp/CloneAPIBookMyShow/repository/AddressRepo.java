package com.jsp.CloneAPIBookMyShow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.CloneAPIBookMyShow.entity.Address;

@Repository
public interface AddressRepo  extends JpaRepository<Address, Long>{

	Optional<Address> findById(long addressId);


}
