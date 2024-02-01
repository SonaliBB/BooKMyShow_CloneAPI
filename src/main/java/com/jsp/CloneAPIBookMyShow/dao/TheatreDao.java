package com.jsp.CloneAPIBookMyShow.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.CloneAPIBookMyShow.entity.Show;
import com.jsp.CloneAPIBookMyShow.entity.Theatre;
import com.jsp.CloneAPIBookMyShow.repository.TheatreRepo;

@Repository
public class TheatreDao {


	@Autowired
	private TheatreRepo theatreRepo;
	
	public Theatre saveTheatre(Theatre theatre) {
		return theatreRepo.save(theatre);
	}
	
	public Theatre   updateTheatre(Theatre theatre,long theatreId) {
		Optional<Theatre> optional=theatreRepo.findById(theatreId);
		if (optional.isPresent()) {
			Theatre oldTheatre=optional.get();
			theatre.setTheatre_id(theatreId);
			theatre.setAddress(oldTheatre.getAddress());
			theatre.setOwner(oldTheatre.getOwner());
			theatre.setScreen(oldTheatre.getScreen());
			theatre.setShows(oldTheatre.getShows());
			theatreRepo.save(theatre);
			return theatre;
		}
		return null;
	}
	
	public Theatre deleteTheatreById(long theatreId) {
		Optional<Theatre> optional=theatreRepo.findById(theatreId);
		if (optional.isEmpty()) {
			return null;
		}
		
		Theatre theatre=optional.get();
		theatre.setAddress(null);
		theatre.setOwner(null);
	List<Show> list=optional.get().getShows();
	for (Show show : list) {
		show.setTheatre(null);
	    }
	
		theatreRepo.deleteById(theatreId);
		return optional.get();
	}
	
	public Theatre getTheatreById(long theatreId) {
		Optional<Theatre> optional=theatreRepo.findById(theatreId);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
}
