package com.jsp.CloneAPIBookMyShow.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.CloneAPIBookMyShow.dao.BookingDao;
import com.jsp.CloneAPIBookMyShow.dto.BookingDto;
import com.jsp.CloneAPIBookMyShow.entity.Booking;
import com.jsp.CloneAPIBookMyShow.util.ResponseStructure;

@Service
public class BookingService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired 
	private BookingDao bookingDao;

	public ResponseEntity<ResponseStructure<BookingDto>> saveBooking(Booking booking) {
		Booking dbbooking=bookingDao.saveBooking(booking);
		BookingDto bookingDto=this.modelMapper.map(dbbooking,BookingDto.class);
		ResponseStructure<BookingDto> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("Bookings saved successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(bookingDto);
		return new ResponseEntity<ResponseStructure<BookingDto>>(responseStructure,HttpStatus.CREATED);
	}
	

	
	
}
