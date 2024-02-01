package com.jsp.CloneAPIBookMyShow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.CloneAPIBookMyShow.dto.BookingDto;
import com.jsp.CloneAPIBookMyShow.entity.Booking;
import com.jsp.CloneAPIBookMyShow.service.BookingService;
import com.jsp.CloneAPIBookMyShow.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/booking")
public class BookingController {
@Autowired
private BookingService bookingService;

@ApiOperation(value = "save booking",notes = "api is used to save booking")
@ApiResponses(value = {@ApiResponse(code = 201,message = "booking saved successfully"),@ApiResponse(code = 404,message = "booking does not saved ,please enter valid details ")})

public ResponseEntity<ResponseStructure<BookingDto>> saveBooking(@RequestBody Booking booking) {
	return bookingService.saveBooking(booking);
}


}
