package com.jsp.CloneAPIBookMyShow.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.CloneAPIBookMyShow.entity.Owner;
import com.jsp.CloneAPIBookMyShow.repository.OwnerRepo;

@Repository	
public class OwnerDao {

	@Autowired
	private OwnerRepo ownerRepo;
	
	public Owner saveOwner(Owner owner) {
		return ownerRepo.save(owner);
	}
	
	public Owner  updateOwner(long ownerId,Owner owner) {
		Optional<Owner> optional=ownerRepo.findById(ownerId);
		if (optional.isPresent()) {
			owner.setOwner_id(ownerId);
			ownerRepo.save(owner);
			return owner;
		}
		return null;
	}
	
	public Owner deleteOwnerById(long ownerId) {
		Optional<Owner> optional=ownerRepo.findById(ownerId);
		if (optional.isPresent()) {
			ownerRepo.deleteById(ownerId);
			return optional.get() ;
		}
		return null;
	}
	
	public Owner findOwnerById(long ownerId) {
	Optional<Owner> optional=ownerRepo.findById(ownerId);
	if (optional.isPresent()) {
		return optional.get();
	}
	return null;
	}
	
}
