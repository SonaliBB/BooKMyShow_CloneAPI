package com.jsp.CloneAPIBookMyShow.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.print.DocFlavor.READER;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.CloneAPIBookMyShow.dao.ScreenDao;
import com.jsp.CloneAPIBookMyShow.dao.TheatreDao;
import com.jsp.CloneAPIBookMyShow.dto.ScreenDto;
import com.jsp.CloneAPIBookMyShow.dto.TheatreDto;
import com.jsp.CloneAPIBookMyShow.entity.Screen;
import com.jsp.CloneAPIBookMyShow.entity.Seat;
import com.jsp.CloneAPIBookMyShow.entity.Theatre;
import com.jsp.CloneAPIBookMyShow.enums.ScreenAvailability;
import com.jsp.CloneAPIBookMyShow.enums.ScreenStatus;
import com.jsp.CloneAPIBookMyShow.enums.SeatType;
import com.jsp.CloneAPIBookMyShow.exception.ScreenIdNotFoundException;
import com.jsp.CloneAPIBookMyShow.exception.TheatreIdNotFoundException;
import com.jsp.CloneAPIBookMyShow.util.ResponseStructure;

@Service
public class ScreenService {
@Autowired
private ModelMapper modelMapper;

@Autowired
private ScreenDao screenDao;
@Autowired
private TheatreDao theatreDao;

public ResponseEntity<ResponseStructure<ScreenDto>> saveScreen(long theatreId,ScreenDto screenDto) {
	Theatre theatre=theatreDao.getTheatreById(theatreId);
	if (theatre!=null) {
		Screen screen=this.modelMapper.map(screenDto, Screen.class);
//      screen variable you are having no of classic seat ,gold,premium seat
//      screen is having seat object???not present and i want to add it
//      screen is having theatre ?no but we are having theatre object themn i will set it(theatre)

		List<Seat> seats=new ArrayList<>();
		for (int i = screen.getNo_of_classic_seat(); i >0; i--) {
			Seat seat=new Seat();
			seat.setSeat_type(null);
			seat.setScreen(screen);
			seats.add(seat);
		}
		for (int i = screen.getNo_of_plantinum_seat(); i >0; i--) {
			Seat seat=new Seat();
			seat.setSeat_type(null);
			seat.setScreen(screen);
			seats.add(seat);
		}
		for (int i = screen.getNo_of_gold_seat(); i >0; i--) {
			Seat seat=new Seat();
			seat.setSeat_type(null);
			seat.setScreen(screen);
			seats.add(seat);
		}
		screen.setTheatre(theatre);
		screen.setSeats(seats);
		screen.setAvailability(ScreenAvailability.NOT_ALLOTED);
		 screen.setScreen_status(null);
		 Screen dbScreen=screenDao.saveScreen(screen);
		 
		 //update the theatre 
		 if (theatre.getScreen().isEmpty()) {
			List<Screen> screens=new ArrayList<>();
			screens.add(dbScreen);
			theatre.setScreen(screens);
			theatreDao.updateTheatre(theatre, theatreId);
		}else {
			List<Screen> screens=theatre.getScreen();
			screens.add(dbScreen);
			theatre.setScreen(screens);
			theatreDao.updateTheatre(theatre, theatreId);
		}
		 ScreenDto dto=this.modelMapper.map(dbScreen, ScreenDto.class);
		 ResponseStructure<ScreenDto> responseStructure=new ResponseStructure<>();
		 responseStructure.setMessage("screen saved successfully");
		 responseStructure.setStatus(HttpStatus.CREATED.value()	);
		 responseStructure.setData(dto);
		 return new ResponseEntity<ResponseStructure<ScreenDto>>(responseStructure,HttpStatus.CREATED);
		 
	}else {
		throw new TheatreIdNotFoundException("failed to add screen cause theatre id not found..");
		
	}

}
public ResponseEntity<ResponseStructure<ScreenDto>> updateScreen(long screenId,ScreenDto screenDto) {
	Screen screen=this.modelMapper.map(screenDto, Screen.class);
	Screen dbScreen=screenDao.updateScreen(screen, screenId);
	if (dbScreen!=null) {
		ScreenDto dto=this.modelMapper.map(dbScreen, ScreenDto.class);
		ResponseStructure<ScreenDto> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("Screen updated sucessfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(dto);
		return new ResponseEntity<ResponseStructure<ScreenDto>>(responseStructure,HttpStatus.OK);
		
	}else {
		throw new ScreenIdNotFoundException("Screen Id not found");
	}
}

public ResponseEntity<ResponseStructure<ScreenDto>> getScreenById(long screenId) {
	
	Screen dbScreen=screenDao.getScreenById(screenId);
	if (dbScreen!=null) {
		ScreenDto dto=this.modelMapper.map(dbScreen, ScreenDto.class);
		ResponseStructure<ScreenDto> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("Screen fetched sucessfully");
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setData(dto);
		return new ResponseEntity<ResponseStructure<ScreenDto>>(responseStructure,HttpStatus.FOUND);

		
	}else {
		throw new ScreenIdNotFoundException("Screen Id not found");
	}
}

public ResponseEntity<ResponseStructure<ScreenDto>> deleteScreenById(long screenId) {
	
	Screen dbScreen=screenDao.deleteScreenById(screenId);
	if (dbScreen!=null) {
		ScreenDto dto=this.modelMapper.map(dbScreen, ScreenDto.class);
		ResponseStructure<ScreenDto> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("Screen fetched sucessfully");
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setData(dto);
		return new ResponseEntity<ResponseStructure<ScreenDto>>(responseStructure,HttpStatus.FOUND);

		
	}else {
		throw new ScreenIdNotFoundException("Screen Id not found");
	}
}

}
