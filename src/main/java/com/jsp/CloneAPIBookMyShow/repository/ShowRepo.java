package com.jsp.CloneAPIBookMyShow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.CloneAPIBookMyShow.entity.Show;

public interface ShowRepo  extends JpaRepository<Show, Long>{

	Optional<Show> findById(long showId);
	
}
