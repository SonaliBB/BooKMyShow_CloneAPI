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

import com.jsp.CloneAPIBookMyShow.dto.TheatreDto;
import com.jsp.CloneAPIBookMyShow.entity.Theatre;
import com.jsp.CloneAPIBookMyShow.service.TheatreService;
import com.jsp.CloneAPIBookMyShow.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/theatre")
public class TheatreController {
@Autowired
private TheatreService theatreService;

@ApiOperation(value = "save theatre",notes = "api used to save theatre data")
@ApiResponses(value = {@ApiResponse(code = 201,message = "theatre data saved  successfully"),@ApiResponse(code = 404,message = "theatre dosen't saved ,please enter valid details")})
@PostMapping
public ResponseEntity<ResponseStructure<Theatre>>	saveTheatre(@RequestParam long ownerId,@RequestParam long addressId,@RequestBody TheatreDto theatreDto	) {
	return theatreService.saveTheatre(ownerId,addressId, theatreDto);
}
@ApiOperation(value = "update theatre",notes = "api used to update theatre data")
@ApiResponses(value = {@ApiResponse(code = 200,message = "theatre data updated  successfully"),@ApiResponse(code = 404,message = "theatre dosen't updated ,please enter valid details")})

@PutMapping
public ResponseEntity<ResponseStructure<Theatre>>	updateTheatre(@RequestParam long theatreId, @RequestBody TheatreDto theatreDto	) {
	return theatreService.updateTheatre(theatreId, theatreDto);
}
@ApiOperation(value = "get theatre",notes = "api used to get theatre data")
@ApiResponses(value = {@ApiResponse(code = 301,message = "theatre data fetched  successfully"),@ApiResponse(code = 404,message = "theatre dosen't found ,please enter valid details")})

@GetMapping
public ResponseEntity<ResponseStructure<Theatre>>	getTheatreById(@RequestParam long theatreId) {
	return theatreService.getTheatreById(theatreId);
}
@ApiOperation(value = "delete theatre",notes = "api used to delete theatre data")
@ApiResponses(value = {@ApiResponse(code = 200,message = "theatre data deleted  successfully"),@ApiResponse(code = 404,message = "theatre dosen't found ,please enter valid details")})

@DeleteMapping
public ResponseEntity<ResponseStructure<Theatre>>	deleteTheatreById(@RequestParam long theatreId) {
	return theatreService.deleteTheatreById(theatreId);
}
}
