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

import com.jsp.CloneAPIBookMyShow.dto.ScreenDto;
import com.jsp.CloneAPIBookMyShow.service.ScreenService;
import com.jsp.CloneAPIBookMyShow.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/screen")
public class ScreenController {

	@Autowired
	private ScreenService screenService;
	
	@ApiOperation(value = "save Screen",notes = "api used to save screen")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "screen saved successfully"),@ApiResponse(code = 404,message = "screen dosen't saved  ,please enter valid details")})
	@PostMapping
	public ResponseEntity<ResponseStructure<ScreenDto>> saveScreen(@RequestParam long theatreId,@RequestBody ScreenDto screenDto) {
		return screenService.saveScreen(theatreId, screenDto);
	}
	@ApiOperation(value = "update Screen",notes = "api used to update screen")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "screen updated  successfully"),@ApiResponse(code = 404,message = "screen dosen't updated  ,please enter valid details")})
	
	@PutMapping
	public ResponseEntity<ResponseStructure<ScreenDto>> updateScreen(@RequestParam long screenId,@RequestBody ScreenDto screenDto) {
		return screenService.updateScreen(screenId, screenDto);
	}
	@ApiOperation(value = "get Screen",notes = "api used to fetch screen data")
	@ApiResponses(value = {@ApiResponse(code = 301,message = "screen fetched  successfully"),@ApiResponse(code = 404,message = "screen dosen't fetched  ,please enter valid details")})
	
	@GetMapping
	public ResponseEntity<ResponseStructure<ScreenDto>> getScreenById(@RequestParam long screenId) {
		return screenService.getScreenById(screenId);
	}
	@ApiOperation(value = "delete Screen",notes = "api used to delete screen data")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "screen deleted  successfully"),@ApiResponse(code = 404,message = "screen dosen't deleted  ,please enter valid details")})
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<ScreenDto>> deleteScreenById(@RequestParam long screenId) {
		return screenService.deleteScreenById(screenId);
	}
}
