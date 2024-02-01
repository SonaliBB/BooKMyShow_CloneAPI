package com.jsp.CloneAPIBookMyShow.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.CloneAPIBookMyShow.entity.Address;
import com.jsp.CloneAPIBookMyShow.repository.AddressRepo;

@Repository
public class AddressDao {
	
   @Autowired
	private AddressRepo addressRepo;
   
	public Address saveAddress(Address address) {
		return addressRepo.save(address);
	}
	

	public Address updateAddress(long addressId ,Address address) {
		
		Optional<Address> optional=addressRepo.findById(addressId);
		 if (optional.isPresent()) {
			address.setAddress_id(addressId);
			address.setTheatre(optional.get().getTheatre());
			addressRepo.save(address);
			return address;
		}
		 
		 return null;
	}
	
	public Address deleteAddress(long addressId) {
		Optional<Address> optional=addressRepo.findById(addressId);
		if (optional.isPresent()) {
			addressRepo.delete(optional.get());
			return optional.get();
		}
		return null;
	}
	
	public Address getAddressById(long addressId) {
		Optional< Address> optional=addressRepo.findById(addressId);
				if (optional.isPresent()) {
					return optional.get();
				}
		return null;
	}
	
}
