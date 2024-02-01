package com.jsp.CloneAPIBookMyShow.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.CloneAPIBookMyShow.dao.MovieDao;
import com.jsp.CloneAPIBookMyShow.dao.ScreenDao;
import com.jsp.CloneAPIBookMyShow.dao.ShowDao;
import com.jsp.CloneAPIBookMyShow.dao.TheatreDao;
import com.jsp.CloneAPIBookMyShow.dto.ShowDto;
import com.jsp.CloneAPIBookMyShow.entity.Movie;
import com.jsp.CloneAPIBookMyShow.entity.Screen;
import com.jsp.CloneAPIBookMyShow.entity.Show;
import com.jsp.CloneAPIBookMyShow.entity.Theatre;
import com.jsp.CloneAPIBookMyShow.enums.ScreenAvailability;
import com.jsp.CloneAPIBookMyShow.exception.MovieIdNotFoundException;
import com.jsp.CloneAPIBookMyShow.exception.ScreenAlreadyAllotedException;
import com.jsp.CloneAPIBookMyShow.exception.ScreenIdNotFoundException;
import com.jsp.CloneAPIBookMyShow.exception.ShowIdNotFoundException;
import com.jsp.CloneAPIBookMyShow.exception.TheatreIdNotFoundException;
import com.jsp.CloneAPIBookMyShow.util.ResponseStructure;

@Service
public class ShowService {
@Autowired 
private ModelMapper modelMapper;
@Autowired
private ShowDao showDao;
@Autowired
private ScreenDao screenDao;
@Autowired
private TheatreDao theatreDao;
@Autowired
private MovieDao movieDao;

public ResponseEntity<ResponseStructure<Show>> addShow(long theatreId,ShowDto showDto ) {
	Theatre dbTheatre=theatreDao.getTheatreById(theatreId);
	if (dbTheatre!=null) {
		Show show=this.modelMapper.map(showDto,Show.class );
		long screenId=show.getScreen_id();
		Screen dbScreen=screenDao.getScreenById(screenId);
		if (dbScreen!=null) {
			if (dbScreen.getAvailability().equals(ScreenAvailability.NOT_ALLOTED)) {
				//Add Show
				long movieId=show.getMovie_id();
				Movie dbMovie=movieDao.getMovieById(movieId);
				if (dbMovie!=null) {
					show.setMovie_description(null);
					show.setMovie_duration(null);
					show.setMovie_language(null);
					show.setScreen_name(null);
					show.setMovie_name(null);
					show.setTheatre(dbTheatre);
					Show dbShow=showDao.addShow(show);
					if (dbTheatre.getShows().isEmpty()) {
						//this is the first show
						List<Show> list=new ArrayList<>();
						list.add(show);
						dbTheatre.setShows(list);
						theatreDao.updateTheatre(dbTheatre, theatreId);
						
					}else {
						//show is already present
						List<Show> list=dbTheatre.getShows();
						list.add(show);
						dbTheatre.setShows(list);
						theatreDao.updateTheatre(dbTheatre, theatreId);
					}
					ResponseStructure<Show> responseStructure=new ResponseStructure<>();
					responseStructure.setMessage("added show successfully");
					responseStructure.setStatus(HttpStatus.CREATED.value());
					responseStructure.setData(dbShow);
					return new ResponseEntity<ResponseStructure<Show>>(responseStructure,HttpStatus.CREATED);
					
				     }else {
					       throw new MovieIdNotFoundException("sorry failed to add show");
				           }
				
			           }else {
				              throw new ScreenAlreadyAllotedException("sorry failed to add show");
				             }
		            }else {
			                throw new ScreenIdNotFoundException("sorry failed to add show");
			              }
		     	}else {
				       throw new TheatreIdNotFoundException("sorry failed to add show");
			     }
}

public ResponseEntity<ResponseStructure<Show>> updateShow(long showId,ShowDto dto) {
	Show show=this.modelMapper.map(dto, Show.class);
	Show dbShow=showDao.updateShow(show, showId);
	if (dbShow!=null) {
		ResponseStructure<Show> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("update show successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(dbShow);
		return new  ResponseEntity<ResponseStructure<Show>>(responseStructure,HttpStatus.OK);
		
	}else {
		throw new ShowIdNotFoundException("sorry failed to update show");
	}
}

public ResponseEntity<ResponseStructure<Show>> getShowById(long showId) {

	Show dbShow=showDao.getShowById(showId);
	if (dbShow!=null) {
		ResponseStructure<Show> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("show data fetched  successfully");
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setData(dbShow);
		return new  ResponseEntity<ResponseStructure<Show>>(responseStructure,HttpStatus.FOUND);
		
	}else {
		throw new ShowIdNotFoundException("sorry failed to fetch  show data");
	}
}

public ResponseEntity<ResponseStructure<Show>> deleteShowById(long showId) {

	Show dbShow=showDao.deleteShow(showId);
	if (dbShow!=null) {
		ResponseStructure<Show> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("show data deleted successfully");
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setData(dbShow);
		return new  ResponseEntity<ResponseStructure<Show>>(responseStructure,HttpStatus.FOUND);
		
	}else {
		throw new ShowIdNotFoundException("sorry failed to delete  show data");
	}
}
}


