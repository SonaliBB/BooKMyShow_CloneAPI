package com.jsp.CloneAPIBookMyShow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.CloneAPIBookMyShow.dto.MovieDto;
import com.jsp.CloneAPIBookMyShow.entity.Movie;
import com.jsp.CloneAPIBookMyShow.service.MovieService;
import com.jsp.CloneAPIBookMyShow.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/movie")
public class MovieController {

@Autowired
private MovieService movieService;

@ApiOperation(value = "save movie" ,notes = "api is used to get the save details")
@ApiResponses(value = {@ApiResponse(code = 200,message = "Movie data saved"),@ApiResponse(code = 404,message = "Movie diden't fetched,please enter valid details")})

@PostMapping
public ResponseEntity<ResponseStructure<MovieDto>> saveMoive(@RequestParam long houseId,@RequestBody MovieDto movieDto) {
return movieService.saveMoive(houseId,movieDto);
}
@ApiOperation(value = "update Movie" ,notes = "api is used to get the Movie details")
@ApiResponses(value = {@ApiResponse(code = 200,message = "customer data updated"),@ApiResponse(code = 404,message = "Movie diden't update,please enter valid details")})

@PutMapping
public ResponseEntity<ResponseStructure<MovieDto>> updateMovie(@RequestParam long movieId,@RequestBody MovieDto dto) {
	return movieService.updateMovie(movieId, dto);
}
@ApiOperation(value = "get Movie" ,notes = "api is used to get the Movie details")
@ApiResponses(value = {@ApiResponse(code = 301,message = "Movie data fetched"),@ApiResponse(code = 404,message = "Movie diden't fetched,please enter valid details")})

@GetMapping
public ResponseEntity<ResponseStructure<MovieDto>> getMovieById(@RequestParam long movieId) {
	return movieService.getMovieById(movieId);
}

@ApiOperation(value = "delete Movie" ,notes = "api is used to delete the Movie details")
@ApiResponses(value = {@ApiResponse(code = 200,message = "Movie data deleted"),@ApiResponse(code = 404,message = "Movie diden't deleted,please enter valid details")})

@DeleteMapping
public ResponseEntity<ResponseStructure<MovieDto>> deleteMovie(@RequestParam long movieId) {
	return movieService.deleteMovieById(movieId);
}

}
