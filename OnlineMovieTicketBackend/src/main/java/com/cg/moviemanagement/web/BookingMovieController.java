package com.cg.moviemanagement.web;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.cg.moviemanagement.dto.BookingForm;
import com.cg.moviemanagement.dto.MovieMessage;
import com.cg.moviemanagement.entities.Booking;
import com.cg.moviemanagement.exceptions.BookingException;
import com.cg.moviemanagement.service.MovieBookingService;
import com.cg.moviemanagement.util.MovieConstants;

/************************************************************************************
 *          @author          Arshad
 *          Description      It is a service interface that provides the services for  
                             Booking a movie ticket  
			
  *         Version             1.0
  *        Created Date      04-SEP-2020
 ************************************************************************************/
@RestController
public class BookingMovieController {
	
	@Autowired
	private MovieBookingService service;
	
	/*********************************************************************************************************************************
	 * Method: AddBooking
     *Description: To add booking details using contact num showid and no.of tickets 
	 * @param name   - input of contact number showid and number of tickets.
	 * @throws LoginException 
	 * @returns      -BookingId
	 * @throws Booking exception - if number of tickets is less than required tickets 
     *Created By    - Arshad
     *Created Date  - 04-SEP-2020                          	 
	 **********************************************************************************************************************************/
	@CrossOrigin
	@PostMapping("/booking")
	public MovieMessage doBooking(@RequestBody BookingForm form, HttpServletRequest request) throws BookingException, LoginException {
		String bookingId = service.addBooking(form);
		MovieMessage msg = new MovieMessage();
		msg.setMessage(bookingId);
		return msg;
		
	}
	
	
	/*********************************************************************************************************************************
	 * Method: CancelBooking
     *Description: To cancel booking  using bookingId
	 * @param name  - input bookingId
	 * @throws LoginException 
	 * @returns     - Alert message
	 * @throws Booking exception - if bookingId doesn't exist
     *Created By    - Arshad
     *Created Date  - 04-SEP-2020                           	 
	 **********************************************************************************************************************************/
	@CrossOrigin
	@GetMapping("/cancelbooking/{bookingid}")
	public MovieMessage cancelBooking(@PathVariable(name="bookingid") String bookingId, HttpServletRequest request) throws BookingException {
		service.cancelBooking(bookingId);
		MovieMessage msg = new MovieMessage();
		msg.setMessage(MovieConstants.BOOKING_CANCELLED);
		return msg;
		
	}

}
