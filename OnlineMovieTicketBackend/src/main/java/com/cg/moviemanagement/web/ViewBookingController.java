package com.cg.moviemanagement.web;

import java.util.List;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.moviemanagement.entities.Booking;
import com.cg.moviemanagement.exceptions.BookingException;
import com.cg.moviemanagement.service.ViewBookingService;
import com.cg.moviemanagement.util.MovieConstants;

/***************************************************************************************************************************
 * 
 * @author -Arshad
 * Description : It is Controller class for the project which handles request made (i.e Contact Number input) from the user
 * and redirects it to the Service class for the logical implementation.
 * @version 1.0
 * @Created Date 04-SEP-2020
***************************************************************************************************************************/
@RestController
public class ViewBookingController {

	@Autowired
	

	private ViewBookingService service;
	@CrossOrigin
	@GetMapping("getbooking/{contact}")    
	public List<Booking> getBookingDetails(@PathVariable("contact") String Contact, HttpServletRequest request) throws BookingException, LoginException 
	{
		List<Booking> bookingDetails = service.getBookingDetails(Contact);
		return bookingDetails;          
		
	}
}
