package com.jsp.CloneAPIBookMyShow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.CloneAPIBookMyShow.entity.Ticket;
import com.jsp.CloneAPIBookMyShow.service.TicketService;
import com.jsp.CloneAPIBookMyShow.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/ticket")
public class TicketController {
@Autowired
private TicketService ticketService;

@ApiOperation(value = "save ticket",notes = "api used to save ticket")
@ApiResponses(value = {@ApiResponse(code = 201,message = "ticket saved  successfully"),@ApiResponse(code = 404,message = "ticket dosen't saved  ,please enter valid details")})

@PostMapping
public ResponseEntity<ResponseStructure<Ticket>> saveTicket(@RequestParam long customerId,@RequestParam long showId,@RequestParam long seatId) {
	return ticketService.saveTicket(customerId, showId, seatId);
}

@ApiOperation(value = "cancel ticket",notes = "api used to cancel ticket")
@ApiResponses(value = {@ApiResponse(code = 200,message = "ticket cancelled  successfully"),@ApiResponse(code = 404,message = "ticket data not found  ,please enter valid details")})

@DeleteMapping
public ResponseEntity<ResponseStructure<Ticket>> cancelTicket(long ticketId) {
	return ticketService.cancelTicket(ticketId);
}
}
