package com.jsp.CloneAPIBookMyShow.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.CloneAPIBookMyShow.entity.Booking;
import com.jsp.CloneAPIBookMyShow.repository.BookingRepo;

@Repository
public class BookingDao {

	@Autowired
	private BookingRepo bookingRepo;
	
	public Booking saveBooking(Booking booking) {
		return bookingRepo.save(booking);
	}
	
	
}
