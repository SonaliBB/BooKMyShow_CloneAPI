package com.jsp.CloneAPIBookMyShow.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.CloneAPIBookMyShow.dao.BookingDao;
import com.jsp.CloneAPIBookMyShow.dao.CustomerDao;
import com.jsp.CloneAPIBookMyShow.dao.SeatDao;
import com.jsp.CloneAPIBookMyShow.dao.ShowDao;
import com.jsp.CloneAPIBookMyShow.dao.TicketDao;
import com.jsp.CloneAPIBookMyShow.entity.Booking;
import com.jsp.CloneAPIBookMyShow.entity.Customer;
import com.jsp.CloneAPIBookMyShow.entity.Seat;
import com.jsp.CloneAPIBookMyShow.entity.Show;
import com.jsp.CloneAPIBookMyShow.entity.Ticket;
import com.jsp.CloneAPIBookMyShow.enums.BookingStatus;
import com.jsp.CloneAPIBookMyShow.enums.SeatType;
import com.jsp.CloneAPIBookMyShow.enums.ShowStatus;
import com.jsp.CloneAPIBookMyShow.enums.TicketStatus;
import com.jsp.CloneAPIBookMyShow.exception.CustomerIdNotFoundException;
import com.jsp.CloneAPIBookMyShow.exception.SeatIdNotFoundException;
import com.jsp.CloneAPIBookMyShow.exception.ShowIdNotFoundException;
import com.jsp.CloneAPIBookMyShow.exception.ShowIsNotActiveException;
import com.jsp.CloneAPIBookMyShow.exception.TicketAlreadyExpiredException;
import com.jsp.CloneAPIBookMyShow.exception.TicketCannotBeCancelledException;
import com.jsp.CloneAPIBookMyShow.exception.TicketIdNotFoundException;
import com.jsp.CloneAPIBookMyShow.util.ResponseStructure;

@Service
public class TicketService {
@Autowired
private TicketDao ticketDao;

@Autowired
private CustomerDao customerDao;
@Autowired
private ShowDao showDao;

@Autowired
private SeatDao seatDao;

@Autowired
private BookingDao bookingDao;

public ResponseEntity<ResponseStructure<Ticket>> saveTicket(long customerId,long showId,long seatId) {
	Customer dbCustomer=customerDao.getCustomerById(customerId);
	Ticket ticket=new  Ticket();
	if (dbCustomer!=null) {
		ticket.setCustomer(dbCustomer);
	}else {
		throw new CustomerIdNotFoundException("sorry failed to book ticket");
	}
	Show dbShow=showDao.getShowById(showId);
	if (dbShow!=null) {
		if (dbShow.getShow_status().equals(ShowStatus.ACTIVE)) {
			ticket.setShow(dbShow);
		}else {
			throw new ShowIsNotActiveException("Sorry failed to book ticket");
		}
	}else {
		throw new ShowIdNotFoundException("sorry failed to book ticket");
	}
	List<Booking> bookings=new ArrayList<>();
	List<Seat> seats=new ArrayList<>();
	double totalprice=0;
	Seat dbSeat=seatDao.getSeatById(seatId);
	if (dbSeat!=null) {
		Booking booking=new Booking();
		booking.setSeat_id(seatId);
		booking.setSeat_type(null);
		booking.setBooking_status(null);
		booking.setBooking_from_time(dbShow.getShow_start_time());
		booking.setBooking_till_time(dbShow.getShow_end_time());
		
		SeatType seatType=booking.getSeat_type();
		switch (seatType) {
		case CLASSIC:
			 booking.setSeatprice(dbShow.getClassic_seat_price());
			 totalprice+=dbShow.getClassic_seat_price();
			break;
			
		case GOLD:
			 booking.setSeatprice(dbShow.getGold_seat_price());
			 totalprice+=dbShow.getGold_seat_price();
			break;
			
		case PLATINUM:
			 booking.setSeatprice(dbShow.getPremium_seat_price());
			 totalprice+=dbShow.getPremium_seat_price();
			break;	
		}
		bookings.add(booking);
		seats.add(dbSeat);
		bookingDao.saveBooking(booking);
		
		ticket.setBooking(bookings);
		ticket.setTotal_price(totalprice);
		ticket.setTicket_status(null);
		Ticket dbTicket=ticketDao.saveTicket(ticket);
		ResponseStructure<Ticket> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("Ticket booked successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(dbTicket);
		return new ResponseEntity<ResponseStructure<Ticket>>(responseStructure,HttpStatus.CREATED);
		
	}
	else {
		throw new SeatIdNotFoundException("sorry failed to book ticket");
	}
}

public ResponseEntity<ResponseStructure<Ticket>> cancelTicket(long ticketId) {
     Ticket dbTicket=ticketDao.getTicketById(ticketId);
     if (dbTicket!=null) {
		if (dbTicket.getShow().getShow_status().equals(ShowStatus.ON_GOING)) {
			throw new TicketCannotBeCancelledException("sorry failed to cancel ticket");
		}else {
			if (dbTicket.getTicket_status().equals(TicketStatus.EXPIRED)) {
				throw new TicketAlreadyExpiredException("sorry failed to cancel ticket");
			}else {
				if (dbTicket.getTicket_status().equals(TicketStatus.CANCELLED)) {
					throw new TicketAlreadyExpiredException("sorry failed to cancel ticket");
				}else {
					List<Booking> bookings=dbTicket.getBooking();
					for (Booking booking : bookings) {
						booking.setBooking_status(null);
						bookingDao.saveBooking(booking);
					}
					dbTicket.setTicket_status(null);
					ticketDao.saveTicket(dbTicket);
					ResponseStructure<Ticket> responseStructure=new  ResponseStructure<>();
					responseStructure.setMessage("Ticket cancelled successfully");
					responseStructure.setStatus(HttpStatus.FOUND.value());
					responseStructure.setData(dbTicket);
					return new ResponseEntity<ResponseStructure<Ticket>>(responseStructure,HttpStatus.FOUND);
				}
			}
		}
	}else {
		throw new TicketIdNotFoundException("sorry failed to cancel ticket");
	}
}

}
