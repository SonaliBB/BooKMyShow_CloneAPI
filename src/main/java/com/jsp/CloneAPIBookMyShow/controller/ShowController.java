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

import com.jsp.CloneAPIBookMyShow.dto.ShowDto;
import com.jsp.CloneAPIBookMyShow.entity.Show;
import com.jsp.CloneAPIBookMyShow.service.ShowService;
import com.jsp.CloneAPIBookMyShow.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
@RequestMapping("/show")
public class ShowController {
@Autowired
private ShowService service;


@ApiOperation(value = "save Show",notes = "api used to save show data")
@ApiResponses(value = {@ApiResponse(code = 201,message = "show data saved  successfully"),@ApiResponse(code = 404,message = "show dosen't saved ,please enter valid details")})
@PostMapping
public ResponseEntity<ResponseStructure<Show>> saveShow(@RequestParam long theatreId, @RequestBody ShowDto dto)
{
return service.addShow(theatreId, dto);
}
@ApiOperation(value = "update Show",notes = "api used to update show data")
@ApiResponses(value = {@ApiResponse(code = 200,message = "show data updated  successfully"),@ApiResponse(code = 404,message = "show dosen't updated ,please enter valid details")})

@PutMapping
public ResponseEntity<ResponseStructure<Show>> updateShow(@RequestParam long showId, @RequestBody ShowDto dto)
{
return service.updateShow(showId, dto);
}

@ApiOperation(value = "get Show",notes = "api used to fetch show data")
@ApiResponses(value = {@ApiResponse(code = 301,message = "show data fetched  successfully"),@ApiResponse(code = 404,message = "show data not found  ,please enter valid details")})

@GetMapping
public ResponseEntity<ResponseStructure<Show>> getShowById(@RequestParam long showId)
{
return service.getShowById(showId);
}

@ApiOperation(value = "delete Show",notes = "api used to delete show data")
@ApiResponses(value = {@ApiResponse(code = 200,message = "show data deleted  successfully"),@ApiResponse(code = 404,message = "show data not found  ,please enter valid details")})

@DeleteMapping
public ResponseEntity<ResponseStructure<Show>> deleteShowById(@RequestParam long showId)
{
return service.deleteShowById(showId);
}

}
