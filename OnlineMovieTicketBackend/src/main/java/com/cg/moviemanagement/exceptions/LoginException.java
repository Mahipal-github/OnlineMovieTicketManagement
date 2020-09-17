package com.cg.moviemanagement.exceptions;

/*************************************************************************************************************************
 * @author Arshad, Poojith, Mahipal
 * Description This is a exception class when user is not available or user id is null then this exception is raised
 *         Version 1.0 
 *         Created Date 04-SEP-2020
 *************************************************************************************************************************/

public class LoginException extends Exception {

	public LoginException() {
		super();

	}

	public LoginException(String arg0) {
		super(arg0);
	}

}
