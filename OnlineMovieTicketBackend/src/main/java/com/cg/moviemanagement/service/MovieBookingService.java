package com.cg.moviemanagement.service;


import com.cg.moviemanagement.exceptions.BookingException;
import com.cg.moviemanagement.dto.BookingForm;

/************************************************************************************
 *          @author          Arshad
 *          Description      It is a service class that provides the services for  adding and cancelling a movie ticket 
  *         Version             1.0
  *         Created Date    04-SEP-2020
 ************************************************************************************/
public interface MovieBookingService {
	
	
	public String addBooking(BookingForm bookingForm)throws BookingException;
	public boolean cancelBooking(String bookingId);
	}


