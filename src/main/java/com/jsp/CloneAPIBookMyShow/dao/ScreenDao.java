package com.jsp.CloneAPIBookMyShow.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.CloneAPIBookMyShow.entity.Screen;
import com.jsp.CloneAPIBookMyShow.repository.ScreenRepo;

@Repository
public class ScreenDao {

	@Autowired
	private ScreenRepo screenRepo;
	
	public  Screen saveScreen(Screen screen) {
		return screenRepo.save(screen);
	}
	
	public  Screen  updateScreen(Screen screen,long screenId) {
		Optional<Screen> optional=screenRepo.findById(screenId);
		if (optional.isPresent()) {
			screen.setScreen_id(screenId);
			screen.setTheatre(optional.get().getTheatre());
			screen.setSeats(optional.get().getSeats());
			screenRepo.save(screen);
			return screen;
		}
		return null;
	}
	
	public Screen deleteScreenById(long screenId) {
		Optional<Screen> optional=screenRepo.findById(screenId);
		if (optional.isPresent()) {
			Screen screen=optional.get();
			screenRepo.delete(screen);
			return screen;
		}
		return null;
	}
	
	public Screen getScreenById(long screenId) {
		Optional<Screen> optional=screenRepo.findById(screenId);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
}
