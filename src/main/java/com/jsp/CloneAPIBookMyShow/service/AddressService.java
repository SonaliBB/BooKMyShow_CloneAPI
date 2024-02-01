package com.jsp.CloneAPIBookMyShow.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.CloneAPIBookMyShow.dao.AddressDao;
import com.jsp.CloneAPIBookMyShow.dto.AddressDto;
import com.jsp.CloneAPIBookMyShow.entity.Address;
import com.jsp.CloneAPIBookMyShow.exception.AddressNotFoundException;
import com.jsp.CloneAPIBookMyShow.util.ResponseStructure;

@Service
public class AddressService {
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private AddressDao addressDao;
	ResponseStructure<Address> responseStructure=new ResponseStructure<>();
	
	public ResponseEntity<ResponseStructure<Address>> saveAddress(AddressDto addressDTO) {
		Address address=this.modelMapper.map(addressDTO, Address.class);
		Address dbaddress=addressDao.saveAddress(address);
		
		responseStructure.setMessage("address saved successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(dbaddress);
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.CREATED);
		
	}
	
	public ResponseEntity<ResponseStructure<Address>> updateAddress(AddressDto addressDto,long addressId) {
		Address address=this.modelMapper.map(addressDto,Address.class);
		Address dbaddress=addressDao.updateAddress(addressId, address);
		if (dbaddress!=null) {
			responseStructure.setMessage("Address updated successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dbaddress);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
		}
		throw new AddressNotFoundException("failed to update the address");
	}
	
	public ResponseEntity<ResponseStructure<Address>> getAddressById(long addressId) {
		Address address=addressDao.getAddressById(addressId);
		if (address!=null) {
			responseStructure.setMessage("Address fetched successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.FOUND);
		}
		throw new AddressNotFoundException("Address Id not found");
		}
	
	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(long addressId) {
		Address address=addressDao.deleteAddress(addressId);
		if (address!=null) {
			responseStructure.setMessage("Address deleted successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
		}
		throw new AddressNotFoundException("Address Id not found");
	}
	
	
}
