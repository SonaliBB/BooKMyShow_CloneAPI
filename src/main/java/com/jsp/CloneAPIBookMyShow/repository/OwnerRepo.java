package com.jsp.CloneAPIBookMyShow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.CloneAPIBookMyShow.entity.Owner;

public interface OwnerRepo extends JpaRepository<Owner, Long>{

	Optional<Owner> findById(long ownerId);

	void deleteById(long ownerId);

}
