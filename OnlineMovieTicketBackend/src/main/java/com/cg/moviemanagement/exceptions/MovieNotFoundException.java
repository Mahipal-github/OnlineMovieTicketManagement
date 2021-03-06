package com.cg.moviemanagement.exceptions;

/*************************************************************************************************************************
 *          @author          Arshad, Poojith, Mahipal
 *          Description      It is an exception class which creates a user defined exception which is to be called whenever,
 *          				 the user searches for a movie that does not exist in the database.
 *         Version             1.0
 *         Created Date    04-SEP-2020
 *************************************************************************************************************************/
public class MovieNotFoundException extends Exception{

	public MovieNotFoundException() {
		super();
	}
	
	public MovieNotFoundException(String msg) {
		super(msg);
	}
}
