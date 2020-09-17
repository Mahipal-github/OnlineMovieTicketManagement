package com.cg.moviemanagement.service;

import java.util.List;

import com.cg.moviemanagement.entities.Movie;
import com.cg.moviemanagement.entities.User;
import com.cg.moviemanagement.exceptions.LoginException;
import com.cg.moviemanagement.exceptions.MovieNotFoundException;

/*************************************************************************************************************************
 * @author Mahipal
 * Description It is a service interface for view movie service.
 *         Version 1.0 
 *         Created Date 04-SEP-2020
 *************************************************************************************************************************/
public interface MovieService {
	public boolean addMovie(Movie movie) throws MovieNotFoundException;
	public List<Movie> viewMovies() throws MovieNotFoundException;
	public List<Movie> viewNewMovies() throws MovieNotFoundException;
}
