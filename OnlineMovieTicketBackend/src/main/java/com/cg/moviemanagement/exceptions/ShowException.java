package com.cg.moviemanagement.exceptions;

/*************************************************************************************************************************
 *          @author          Arshad, Poojith, Mahipal
 *          Description      It is an exception class which creates a user defined exception which is to be called whenever,
 *          				 the user searches for a show that does not exist in the database.
 *         Version             1.0
 *         Created Date    04-SEP-2020
 *************************************************************************************************************************/
public class ShowException extends Exception {
	public ShowException(String s)
	{
		super(s);
	}

	public ShowException() {
		super();
		
	}

	
}
