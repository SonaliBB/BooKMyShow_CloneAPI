package com.jsp.CloneAPIBookMyShow.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.CloneAPIBookMyShow.dao.MovieDao;
import com.jsp.CloneAPIBookMyShow.dao.ProductionHouseDao;
import com.jsp.CloneAPIBookMyShow.dto.MovieDto;
import com.jsp.CloneAPIBookMyShow.entity.Movie;
import com.jsp.CloneAPIBookMyShow.entity.ProductionHouse;
import com.jsp.CloneAPIBookMyShow.exception.MovieIdNotFoundException;
import com.jsp.CloneAPIBookMyShow.exception.ProductionHouseNotFoundException;
import com.jsp.CloneAPIBookMyShow.util.ResponseStructure;

@Service
public class MovieService {
@Autowired
private ModelMapper mapper;

@Autowired
private MovieDao dao;

@Autowired
private ProductionHouseDao houseDao;

public ResponseEntity<ResponseStructure<MovieDto>> saveMoive(long houseId, MovieDto movieDto) {

	ProductionHouse house=houseDao.getProductionHouseById(houseId);
	if (house!=null) {
		//add movie
		Movie movie=this.mapper.map(movieDto,Movie.class);
		movie.setProductionHouse(house);
		Movie dbMovie=dao.saveMovie(movie);
		
		//update production
		if (house.getMovies().isEmpty()) {
			List<Movie> list=new ArrayList<Movie>();
		   list.add(movie);
		   house.setMovies(list);
		   houseDao.updateProductionHouse(house, houseId);
		}
		else {
			List<Movie> list=house.getMovies();
			list.add(movie);
			house.setMovies(list);
			houseDao.updateProductionHouse(house, houseId);
					}
		ResponseStructure<MovieDto> structure=new ResponseStructure<>();
		structure.setMessage("movie saved successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(this.mapper.map(dbMovie, MovieDto.class));
		return new ResponseEntity<ResponseStructure<MovieDto>>(structure,HttpStatus.CREATED);
	}
	else {
		throw new ProductionHouseNotFoundException("sorry failed to add movie");
	}
}

public ResponseEntity<ResponseStructure<MovieDto>> updateMovie(long movieId,MovieDto movieDto) {
	Movie movie=this.mapper.map(movieDto, Movie.class);
	Movie dbMovie=dao.updateMovie(movieId, movie);
	if (dbMovie!=null) {
		ResponseStructure<MovieDto> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("Movie updated successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(this.mapper.map(dbMovie, MovieDto.class));
		return new ResponseEntity<ResponseStructure<MovieDto>>(responseStructure,HttpStatus.OK);
		
	}
	else {
		throw new MovieIdNotFoundException("Sorry,failed to update movie");
	}
}

public ResponseEntity<ResponseStructure<MovieDto>> getMovieById(long movieId) {
	Movie dbmovie=dao.getMovieById(movieId);
	if (dbmovie!=null) {
		ResponseStructure<MovieDto> structure=new ResponseStructure<MovieDto>();
		structure.setMessage("Movie fetched successfully");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(this.mapper.map(dbmovie, MovieDto.class));
		return new ResponseEntity<ResponseStructure<MovieDto>>(structure,HttpStatus.FOUND);
		
	}else {
		throw new MovieIdNotFoundException("Sorry,failed to get movie details");
	}
	
}
public ResponseEntity<ResponseStructure<MovieDto>> deleteMovieById(long movieId) {
	Movie movie=dao.deleteMovie(movieId);
	if (movie!=null) {
		ResponseStructure<MovieDto> structure=new ResponseStructure<MovieDto>();
		structure.setMessage("Movie fetched successfully");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(this.mapper.map(movie, MovieDto.class));
		return new ResponseEntity<ResponseStructure<MovieDto>>(structure,HttpStatus.FOUND);
	}else {
		throw new MovieIdNotFoundException("sorry,failed to delete movie");
	}
}
}
