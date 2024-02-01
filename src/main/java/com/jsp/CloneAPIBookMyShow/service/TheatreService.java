package com.jsp.CloneAPIBookMyShow.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.CloneAPIBookMyShow.dao.AddressDao;
import com.jsp.CloneAPIBookMyShow.dao.OwnerDao;
import com.jsp.CloneAPIBookMyShow.dao.TheatreDao;
import com.jsp.CloneAPIBookMyShow.dto.TheatreDto;
import com.jsp.CloneAPIBookMyShow.entity.Address;
import com.jsp.CloneAPIBookMyShow.entity.Owner;
import com.jsp.CloneAPIBookMyShow.entity.Theatre;
import com.jsp.CloneAPIBookMyShow.exception.AddressNotFoundException;
import com.jsp.CloneAPIBookMyShow.exception.OwnerIdNotFoundException;
import com.jsp.CloneAPIBookMyShow.exception.TheatreAlreadyPresentInThisAddressException;
import com.jsp.CloneAPIBookMyShow.exception.TheatreIdNotFoundException;
import com.jsp.CloneAPIBookMyShow.util.ResponseStructure;

@Service
public class TheatreService {
@Autowired
private ModelMapper mapper;

@Autowired
private TheatreDao dao;

@Autowired
private AddressDao addressDao;

@Autowired
private OwnerDao ownerDao;

public ResponseEntity<ResponseStructure<Theatre>> saveTheatre(long ownerId,long addressId,TheatreDto theatreDto)
{
	Owner owner=ownerDao.findOwnerById(ownerId);
	if (owner!=null) {
		Address address=addressDao.getAddressById(addressId);
		if (address!=null) {
			Theatre addressTheatre=address.getTheatre();
			if (addressTheatre!=null) {
				throw new TheatreAlreadyPresentInThisAddressException("sorry the address mapped is not correct");
			}
			Theatre theatre=this.mapper.map(theatreDto, Theatre.class);
			theatre.setOwner(owner);
			theatre.setAddress(address);
			//update owner
			if (owner.getTheatres().isEmpty()) {
				List<Theatre> list=new ArrayList<>();
				list.add(theatre);
				owner.setTheatres(list);
			}else {
				List<Theatre> list=owner.getTheatres();
				list.add(theatre);
				owner.setTheatres(list);
			}
			//update address
			
			address.setTheatre(theatre);
			//add theatre
			Theatre dbTheatre=dao.saveTheatre(theatre);
		ResponseStructure<Theatre> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("Theatre added successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(dbTheatre);
		return new ResponseEntity<ResponseStructure<Theatre>>(responseStructure,HttpStatus.CREATED);
			
		}else {
			throw new AddressNotFoundException("sorry failed to add theatre");
		}
	}else {
		throw new OwnerIdNotFoundException("sorry failed to add theatre");
	}
}

public ResponseEntity<ResponseStructure<Theatre >> updateTheatre(long theatreId,TheatreDto dto) {
	Theatre theatre=this.mapper.map(dto, Theatre.class);
	Theatre dbTheatre=dao.updateTheatre(theatre, theatreId);
	if (dbTheatre!=null) {
		ResponseStructure<Theatre> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("Theatre updated successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(dbTheatre);
		return new ResponseEntity<ResponseStructure<Theatre>>(responseStructure,HttpStatus.OK);
			
		}else {
			throw new TheatreIdNotFoundException("sorry failed to update theatre");
		}
}

public ResponseEntity<ResponseStructure<Theatre >> getTheatreById(long theatreId) {

	Theatre dbTheatre=dao.getTheatreById( theatreId);
	if (dbTheatre!=null) {
		ResponseStructure<Theatre> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("Theatre fetched successfully");
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setData(dbTheatre);
		return new ResponseEntity<ResponseStructure<Theatre>>(responseStructure,HttpStatus.FOUND);
			
		}else {
			throw new TheatreIdNotFoundException("sorry failed to fetch theatre");
		}
}
public ResponseEntity<ResponseStructure<Theatre >> deleteTheatreById(long theatreId) {

	Theatre dbTheatre=dao.deleteTheatreById( theatreId);
	if (dbTheatre!=null) {
		ResponseStructure<Theatre> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("Theatre deleted successfully");
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setData(dbTheatre);
		return new ResponseEntity<ResponseStructure<Theatre>>(responseStructure,HttpStatus.FOUND);
			
		}else {
			throw new TheatreIdNotFoundException("sorry failed to delete theatre");
		}
}

}
