package com.jsp.CloneAPIBookMyShow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.CloneAPIBookMyShow.entity.Theatre;

public interface TheatreRepo extends JpaRepository<Theatre, Long> {

	Optional<Theatre> findById(long theatreId);

	void deleteById(long theatreId);
}
