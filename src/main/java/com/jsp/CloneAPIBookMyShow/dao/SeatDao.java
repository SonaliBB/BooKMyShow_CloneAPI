package com.jsp.CloneAPIBookMyShow.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.CloneAPIBookMyShow.entity.Seat;
import com.jsp.CloneAPIBookMyShow.repository.SeatRepo;

@Repository
public class SeatDao {

	@Autowired
	private SeatRepo seatRepo;
	
	public Seat saveSeat(Seat seat) {
		return seatRepo.save(seat);
	}
	
	public Seat	updateSeat(Seat seat,long seatId) {
		Optional<Seat> optional=seatRepo.findById(seatId);
		if (optional.isPresent()) {
			return seatRepo.save(seat);
		}
		return null;
	}
	
	public Seat  deleteSeat(long seatId) {
		Optional<Seat> optional=seatRepo.findById(seatId);
		if (optional.isPresent()) {
			Seat seat=optional.get();
			  seatRepo.delete(seat);
			  return seat;
		}
		return null;
	}
	
	public Seat getSeatById(long seatId) {
		Optional<Seat> optional=seatRepo.findById(seatId);
		if (optional.isEmpty()) {
			return null;
		}
		else {
			return optional.get();
		}
	}
}
