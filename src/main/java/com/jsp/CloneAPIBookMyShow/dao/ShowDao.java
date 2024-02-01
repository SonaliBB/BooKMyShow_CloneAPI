package com.jsp.CloneAPIBookMyShow.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.CloneAPIBookMyShow.entity.Show;
import com.jsp.CloneAPIBookMyShow.repository.ShowRepo;

@Repository
public class ShowDao {

	@Autowired
	private ShowRepo showRepo;
	
	public Show	 addShow(Show show	) {
		return showRepo.save(show);
	}
	
	public Show  updateShow(Show show,long showId) {
		Optional<Show> optional=showRepo.findById(showId);
		if (optional.isPresent()) {
			show.setShow_id(showId);
			show.setTheatre(optional.get().getTheatre());
			showRepo.save(show);
			return show;
		}
		return null;
	}
	
   public Show  deleteShow(long showId) {
	   Optional<Show> optional=showRepo.findById(showId);
		if (optional.isPresent()) {
			Show show=optional.get();
			showRepo.delete(show);
			return optional.get();
		}
		return null;
}
   
   public Show  getShowById(long showId) {
	   Optional<Show> optional=showRepo.findById(showId);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
}
}
