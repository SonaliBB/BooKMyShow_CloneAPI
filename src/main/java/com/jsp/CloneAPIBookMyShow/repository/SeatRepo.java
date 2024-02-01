 package com.jsp.CloneAPIBookMyShow.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.CloneAPIBookMyShow.entity.Seat;

public interface SeatRepo extends JpaRepository<Seat, Long> {

	Optional<Seat> findById(long seatId);
}
