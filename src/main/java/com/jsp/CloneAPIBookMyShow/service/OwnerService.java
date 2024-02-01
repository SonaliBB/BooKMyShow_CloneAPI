package com.jsp.CloneAPIBookMyShow.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.CloneAPIBookMyShow.dao.OwnerDao;
import com.jsp.CloneAPIBookMyShow.dto.OwnerDto;
import com.jsp.CloneAPIBookMyShow.entity.Owner;
import com.jsp.CloneAPIBookMyShow.exception.OwnerIdNotFoundException;
import com.jsp.CloneAPIBookMyShow.util.ResponseStructure;

@Service
public class OwnerService {

	@Autowired
	private OwnerDao ownerDao;
	@Autowired
	private ModelMapper modelMapper;
	
	public ResponseEntity<ResponseStructure<OwnerDto>> saveOwner(Owner owner) {
		Owner dbOwner=ownerDao.saveOwner(owner);
		OwnerDto dto=new OwnerDto();
		dto.setOwner_id(owner.getOwner_id());
		dto.setOwner_name(owner.getOwner_name());
		dto.setOwner_email(owner.getOwner_email());
		dto.setOwner_phoneno(owner.getOwner_phoneno());
		
		ResponseStructure<OwnerDto> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("owner saved successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(dto);
		return new ResponseEntity<ResponseStructure<OwnerDto>>(responseStructure,HttpStatus.CREATED);
		
	}
	public ResponseEntity<ResponseStructure<OwnerDto>> updateOwner(long ownerId,Owner owner) {
		Owner dbOwner=ownerDao.updateOwner(ownerId, owner);
		if (dbOwner!=null) {
			OwnerDto dto=new OwnerDto();
			dto.setOwner_id(ownerId);
			dto.setOwner_name(null);
			dto.setOwner_email(null);
			dto.setOwner_phoneno(ownerId);
			
			ResponseStructure<OwnerDto> responseStructure=new ResponseStructure<>();
			responseStructure.setMessage("owner updated successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dto);
			return new ResponseEntity<ResponseStructure<OwnerDto>>(responseStructure,HttpStatus.OK);
		}else {
			throw new OwnerIdNotFoundException("sorry failed to update Owner detalis");
		}
	}
	
	public ResponseEntity<ResponseStructure<OwnerDto>> findOwnerById(long ownerId) {
		Owner dbOwner=ownerDao.findOwnerById(ownerId);
		if (dbOwner!=null) {
			OwnerDto dto=new OwnerDto();
			dto.setOwner_id(ownerId);
			dto.setOwner_name(null);
			dto.setOwner_email(null);
			dto.setOwner_phoneno(ownerId);
			
			ResponseStructure<OwnerDto> responseStructure=new ResponseStructure<>();
			responseStructure.setMessage("owner fetched successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dto);
			return new ResponseEntity<ResponseStructure<OwnerDto>>(responseStructure,HttpStatus.OK);
		}else {
			throw new OwnerIdNotFoundException("sorry failed to get Owner detalis");
		}
		
	}
	public ResponseEntity<ResponseStructure<OwnerDto>> deleteOwnerBYId(long ownerId) {
		Owner dbOwner=ownerDao.deleteOwnerById(ownerId);
		if (dbOwner!=null) {
			OwnerDto dto=new OwnerDto();
			dto.setOwner_id(ownerId);
			dto.setOwner_name(null);
			dto.setOwner_email(null);
			dto.setOwner_phoneno(ownerId);
			
			ResponseStructure<OwnerDto> responseStructure=new ResponseStructure<>();
			responseStructure.setMessage("owner deleted successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(dto);
			return new ResponseEntity<ResponseStructure<OwnerDto>>(responseStructure,HttpStatus.FOUND);
		}else {
			throw new OwnerIdNotFoundException("sorry failed to delete Owner detalis");
		}
		
		
	}
}
