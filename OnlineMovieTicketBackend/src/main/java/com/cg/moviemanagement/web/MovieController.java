package com.cg.moviemanagement.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.moviemanagement.dto.MovieMessage;
import com.cg.moviemanagement.entities.Movie;
import com.cg.moviemanagement.entities.User;
import com.cg.moviemanagement.exceptions.LoginException;
import com.cg.moviemanagement.exceptions.MovieNotFoundException;
import com.cg.moviemanagement.service.MovieService;
import com.cg.moviemanagement.util.MovieConstants;

/************************************************************************************************************************
 *          @author          Mahipal
 *          Description      It is a controller class, having functions which call service and display movies. 
  *         Version             1.0
  *         Created Date    04-SEP-2020
 ************************************************************************************************************************/
@RestController
public class MovieController {

	@Autowired
	private MovieService service;
	
/*********************************************************************************************************************************
	 * Method: addmovie
     *Description: To add a movie when a request is made from database. 
	 * @throws MovieNotFoundException 
	 * @returns msg       - if movie gets added or it already exists it will give message.
                *Created By        - Mahipal
                *Created Date     - 04-SEP-2020                           	 
**********************************************************************************************************************************/
	 
	@CrossOrigin
	@PostMapping("/addmovie")
	public MovieMessage addMovie(@RequestBody Movie movie, HttpServletRequest request) throws MovieNotFoundException, LoginException {
		try{
			service.addMovie(movie);
			MovieMessage msg = new MovieMessage();
			msg.setMessage(MovieConstants.MOVIE_ADDED);
			return msg;
		}
			catch (DataIntegrityViolationException ex) {
			throw new MovieNotFoundException(MovieConstants.ID_EXISTS);
		}
	}
	
/*********************************************************************************************************************************
	 * Method: viewmovies
     *Description: To give a list of movies in database. 
	 * @throws MovieNotFoundException 
	 * @returns List<Movie>       - all movies which are currently active.
                *Created By        - Mahipal
                *Created Date     - 04-SEP-2020                           	 
**********************************************************************************************************************************/
	 
	@CrossOrigin
	@GetMapping("/viewmovies")
	public List<Movie> viewMovies(HttpServletRequest request) throws MovieNotFoundException {	
		return service.viewMovies();
	}
	
/*********************************************************************************************************************************
	 * Method: viewnewmovies
     *Description: To give a list of new movies in database. 
	 * @throws MovieNotFoundException 
	 * @throws LoginException 
	 * @returns List<Movie>       - all movies which are recently added and currently active.
                *Created By       - Mahipal
                *Created Date    - 04-SEP-2020                           	 
**********************************************************************************************************************************/
	@CrossOrigin
	@GetMapping("/viewnewmovies")
	public List<Movie> viewNewMovies(HttpServletRequest request) throws MovieNotFoundException{
		return service.viewNewMovies();
	}
}
