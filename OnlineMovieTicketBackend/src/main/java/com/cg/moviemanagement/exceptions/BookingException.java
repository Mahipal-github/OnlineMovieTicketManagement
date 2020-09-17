package com.cg.moviemanagement.exceptions;

/*************************************************************************************************************************
 * @author Arshad, Poojith, Mahipal
 * Description This is a exception class when user wants more tickets than available and user want to cancel for a
 *                        non existing booking id
 *         Version 1.0 
 *         Created Date 04-SEP-2020
 *************************************************************************************************************************/
public class BookingException extends Exception{

	public BookingException() {
		super();
		
	}

	public BookingException(String arg0) {
		super(arg0);
		
	}

	
}
