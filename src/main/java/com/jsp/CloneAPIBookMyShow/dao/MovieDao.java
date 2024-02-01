package com.jsp.CloneAPIBookMyShow.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.CloneAPIBookMyShow.entity.Movie;
import com.jsp.CloneAPIBookMyShow.repository.MovieRepo;

@Repository
public class MovieDao {

	@Autowired
	private MovieRepo movieRepo;
	
	public Movie saveMovie(Movie movie) {
		return movieRepo.save(movie);
	}
	
	public Movie updateMovie(long movieId , Movie movie) {
		Optional< Movie> optional=movieRepo.findById(movieId);
		if (optional.isPresent()) {
			movie.setMovie_id(movieId);
			movie.setProductionHouse(optional.get().getProductionHouse());
			movieRepo.save(movie);
			return movie;
		}
		return null;
	}
	
	public Movie deleteMovie(long movieId) {
		Optional<Movie> optional=movieRepo.findById(movieId);
		if (optional.isPresent()) {
			movieRepo.delete(optional.get());
			return optional.get();
		}
		return null;
	}
	
	public Movie  getMovieById(long movieId) {
		Optional<Movie> optional=movieRepo.findById(movieId);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public Movie deleteMovieById(long movieId) {
		Optional<Movie> optional=movieRepo.findById(movieId);
		if (optional.isPresent()) {
			movieRepo.delete(optional.get());
			 Movie movie=optional.get();
			 movie.setProductionHouse(null);
			 movieRepo.delete(movie);
			 return movie;
		}
		return null;
	}
	
}
