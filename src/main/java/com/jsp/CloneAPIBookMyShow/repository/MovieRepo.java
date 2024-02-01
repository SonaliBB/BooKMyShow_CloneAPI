package com.jsp.CloneAPIBookMyShow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.CloneAPIBookMyShow.entity.Movie;

public interface MovieRepo extends JpaRepository<Movie,Long> {

	Optional<Movie> findById(long movieId);

}
