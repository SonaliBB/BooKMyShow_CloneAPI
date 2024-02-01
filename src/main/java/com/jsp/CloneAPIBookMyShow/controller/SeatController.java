package com.jsp.CloneAPIBookMyShow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.CloneAPIBookMyShow.dto.SeatDto;
import com.jsp.CloneAPIBookMyShow.entity.Seat;
import com.jsp.CloneAPIBookMyShow.service.SeatService;
import com.jsp.CloneAPIBookMyShow.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/seat")
public class SeatController {

	@Autowired
	private SeatService seatService;
	
@ApiOperation(value = "save seat",notes = "api is used to save seat")
@ApiResponses(value = {@ApiResponse(code = 201,message = "seat saved successfully"),@ApiResponse(code = 404,message = "seat not saved ,please enter the valid credentials")})
	@PostMapping
	public ResponseEntity<ResponseStructure<Seat>> saveSeat(@RequestParam long screenId,@RequestParam SeatDto seatDto) {
		return seatService.saveSeat(screenId, seatDto);
	}
	
@ApiOperation(value = "update seat",notes = "api is used to update seat")
@ApiResponses(value = {@ApiResponse(code = 200,message = "seat updated successfully"),@ApiResponse(code = 404,message = "seat not updated ,please enter the valid credentials")})

	@PutMapping
	public ResponseEntity<ResponseStructure<Seat>> updateSeat(@RequestParam long seatId,@RequestParam SeatDto seatDto) {
		return seatService.updateSeat(seatId, seatDto);
	}
	
@ApiOperation(value = "fetch seat",notes = "api is used to fetch seat")
@ApiResponses(value = {@ApiResponse(code = 301,message = "seat get successfully"),@ApiResponse(code = 404,message = "seat data didn't fetched,please enter the valid credentials")})

	@GetMapping
	public ResponseEntity<ResponseStructure<Seat>> getSeatById(@RequestParam long seatId) {
		return seatService.getSeatById(seatId);
	}
	
@ApiOperation(value = "delete seat",notes = "api is used to delete seat")
@ApiResponses(value = {@ApiResponse(code = 200,message = "seat saved successfully"),@ApiResponse(code = 404,message = "seat not saved ,please enter the valid credentials")})

	@DeleteMapping
	public ResponseEntity<ResponseStructure<Seat>> deleteSeatById(@RequestParam long seatId) {
		return seatService.getSeatById(seatId);
	}
}
