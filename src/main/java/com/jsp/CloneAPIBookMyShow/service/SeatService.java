package com.jsp.CloneAPIBookMyShow.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.CloneAPIBookMyShow.dao.ScreenDao;
import com.jsp.CloneAPIBookMyShow.dao.SeatDao;
import com.jsp.CloneAPIBookMyShow.dto.SeatDto;
import com.jsp.CloneAPIBookMyShow.entity.Screen;
import com.jsp.CloneAPIBookMyShow.entity.Seat;
import com.jsp.CloneAPIBookMyShow.exception.SeatIdNotFoundException;
import com.jsp.CloneAPIBookMyShow.util.ResponseStructure;

@Service
public class SeatService {
@Autowired 
private SeatDao seatDao;

@Autowired
private ModelMapper modelMapper;
@Autowired
private ScreenDao screenDao;

public ResponseEntity<ResponseStructure<Seat>> saveSeat(long screenId,SeatDto seatDto) {
	Screen screen=screenDao.getScreenById(screenId);
	if (screen!=null) {
		Seat seat=this.modelMapper.map(seatDto, Seat.class);
		seat.setScreen(screen);
		Seat dbSeat =seatDao.saveSeat(seat);
		ResponseStructure<Seat> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("seat saved successfully");
		return new ResponseEntity<ResponseStructure<Seat>>(responseStructure,HttpStatus.CREATED	);
	}else {
		throw new SeatIdNotFoundException("sorry failed to save the seat for you");
	}
}

public ResponseEntity<ResponseStructure<Seat>> updateSeat(long seatId,SeatDto seatDto) {
	Seat seat=this.modelMapper.map(seatDto,Seat.class);
	Seat dbSeat=seatDao.updateSeat(seat, seatId);
	if (dbSeat!=null) {
		ResponseStructure<Seat> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("data updated successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(dbSeat);
		return new ResponseEntity<ResponseStructure<Seat>>(responseStructure,HttpStatus.OK);
		
	}else {
		throw new SeatIdNotFoundException("failed to update seat");
	}
}

public ResponseEntity<ResponseStructure<Seat>> getSeatById(long seatId) {
	
	Seat dbSeat=seatDao.getSeatById(seatId);
	if (dbSeat!=null) {
		ResponseStructure<Seat> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("data fetched successfully");
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setData(dbSeat);
		return new ResponseEntity<ResponseStructure<Seat>>(responseStructure,HttpStatus.FOUND);
		
	}else {
		throw new SeatIdNotFoundException("failed to fetch seat data");
	}
}

public ResponseEntity<ResponseStructure<Seat>> deleteSeatById(long seatId) {
	
	Seat dbSeat=seatDao.deleteSeat(seatId);
	if (dbSeat!=null) {
		ResponseStructure<Seat> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("data deleted successfully");
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setData(dbSeat);
		return new ResponseEntity<ResponseStructure<Seat>>(responseStructure,HttpStatus.FOUND);
		
	}else {
		throw new SeatIdNotFoundException("failed to delete seat data");
	}
}

}
