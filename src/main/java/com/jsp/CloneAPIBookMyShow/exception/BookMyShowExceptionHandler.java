package com.jsp.CloneAPIBookMyShow.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.CloneAPIBookMyShow.util.ResponseStructure;

@RestControllerAdvice
public class BookMyShowExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		    List<ObjectError> list=ex.getAllErrors();
		    Map<String, String> map=new HashMap<String,String>();
		    for (ObjectError objectError : list) {
				String message=objectError.getDefaultMessage();
				String fieldname=((FieldError)objectError).getField();
				map.put(fieldname, message);
			}
		    return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> ownerIdNotFound(OwnerIdNotFoundException ex){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setMessage("Id not found for Owner");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> ticketIdNotFound(TicketIdNotFoundException ex){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setMessage("Id not found for Ticket");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> ticketAlreadyExpired(TicketAlreadyExpiredException ex){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setMessage("Sorry,Ticket already  expired");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> ticketAlreadyCancelled(TicketAlreadyCancelledException ex){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setMessage("Sorry,Ticket already  cancelled");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> ticketCannotBeCancelled(TicketCannotBeCancelledException ex){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setMessage("Sorry,Ticket cannot be cancelled");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> customerIdNotFound(CustomerIdNotFoundException ex){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setMessage("Id not found for Customer");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> movieIdNotFound(MovieIdNotFoundException ex){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setMessage("Id not found for Movie");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> productionHouseIdNotFound(ProductionHouseNotFoundException ex){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setMessage("Id not found for Production House");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> screenIdNotFound(ScreenIdNotFoundException ex){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setMessage("Id not found for Screen");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> screenAlreadyAlloted(ScreenAlreadyAllotedException ex){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setMessage("Sorry,Screen already alloted");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> showIdNotFound(ShowIdNotFoundException ex){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setMessage("Id not found for Show");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> showIsNotActive(ShowIsNotActiveException ex){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setMessage("Sorry,show is not active");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> theatreAlreadyPresentInThisAddress(TheatreAlreadyPresentInThisAddressException ex){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setMessage("Sorry,Theatre already present in this address");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> theatreAlreadyPresentInThisLocation(TheatreAlreadyPresentInThisLocationException ex){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setMessage("Sorry,theatre already present in this location");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> theatreIdNotFound(TheatreIdNotFoundException ex){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setMessage("Id not found for Theatre");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> seatIdNotFound(SeatIdNotFoundException ex){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setMessage("Id not found for Seat");
		responseStructure.setData(ex.getMessage());
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	
}
