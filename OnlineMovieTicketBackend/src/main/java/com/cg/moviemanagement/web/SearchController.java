package com.cg.moviemanagement.web;

import java.time.LocalDate;
import java.util.List;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.moviemanagement.entities.Movie;
import com.cg.moviemanagement.entities.Show;
import com.cg.moviemanagement.exceptions.MovieNotFoundException;
import com.cg.moviemanagement.exceptions.ShowException;
import com.cg.moviemanagement.service.SearchService;
import com.cg.moviemanagement.util.MovieConstants;

/************************************************************************************************************************************
 *          @author          Poojith, Mahipal
 *          Description      It is a controller class having Request Mapping functions for functionalities of search movies/ shows.
 *         Version             1.0
 *         Created Date    04-SEP-2020
************************************************************************************************************************************/


@RestController
public class SearchController {
	
	@Autowired
	private SearchService serviceObject;

/*********************************************************************************************************************************
	 * Method: searchMovie
     *Description: To search a movie based on user input of director / language / genre / movie name. 
	 * @param name              - input of  director / language / genre / movie name.
	 * @returns movieList       - all movies whose criteria matches input given by user.
	 * @throws MovieNotFoundException - When the user searched for a movie that does not exists in database, exception is thrown. 
                *Created By     - Mahipal
                *Created Date   - 04-SEP-2020                          	 
**********************************************************************************************************************************/
	@CrossOrigin
	@GetMapping("/searchmovie/{name}")
	public List<Movie> searchMovie(@PathVariable("name") String name, HttpServletRequest request) throws MovieNotFoundException, LoginException {
		List<Movie> movieList=serviceObject.getMovies(name);
		if(movieList.isEmpty()) {
			throw new MovieNotFoundException(MovieConstants.MOVIE_NOT_AVAILABLE);
		}
		return movieList;
	}

	
	
/*********************************************************************************************************************************
	 * Method: getShowsForScreen
     *Description: To search a show based on input of screen name from user.. 
	 * @param screenname              - screen name where movie is to be displayed.
	 * @returns showList       - all shows whose criteria matches input given by user.
	 * @throws ShowException - When the user searched for a screen that does have any shows in database, exception is thrown. 
                *Created By    - Poojith
                *Created Date  - 04-SEP-2020                          	 
**********************************************************************************************************************************/
	@CrossOrigin
	@GetMapping("/showsforscreen/{screenname}")
	public List<Show> getShowsForScreen(@PathVariable("screenname") String screenName, HttpServletRequest request) throws ShowException
	{
		List<Show> shows = serviceObject.getShows(screenName);
		return shows;
		
		
	}
	

/*********************************************************************************************************************************
	 * Method: getShowsForScreenMovieDate
     *Description: To search a show based on input of screen name and movie id and date from user. 
	 * @param screenname              - screen name where movie is to be displayed.
	 * @param movieid              - movie id for which the shows are to be searched.
	 * @param searchdt              - Date at which show is to be shown.
	 * @returns showList       - all shows whose criteria matches input given by user.
	 * @throws ShowException - When the user searched for a screen that does have any shows in database, exception is thrown. 
                *Created By        - Poojith
                *Created Date     - 04-SEP-2020                          	 
**********************************************************************************************************************************/
	@CrossOrigin
	@GetMapping("/viewshowsforscreenmoviedt/{screenname}/{movieid}/{searchdt}")
	public List<Show> getShowsForScreenMovieDate(@PathVariable("screenname") String screenName, @PathVariable("movieid") int movieid ,
			@PathVariable("searchdt") @DateTimeFormat(pattern="yyyy-M-d") LocalDate searchDt , HttpServletRequest request) throws ShowException{
	
		List<Show> shows = serviceObject.getShows(screenName, searchDt, movieid);
		return shows;

		
	}

/*********************************************************************************************************************************
	 * Method: getShowsForScreenDate
     *Description: To search a show based on input of screen name and date from user. 
	 * @param screenname              - screen name where movie is to be displayed.
	 * @param searchdt              - Date at which show is to be shown.
	 * @returns showList       - all shows whose criteria matches input given by user.
	 * @throws ShowException - When the user searched for a screen that does have any shows in database, exception is thrown. 
                *Created By        - Poojith
                *Created Date       - 04-SEP-2020                           	 
**********************************************************************************************************************************/
	@CrossOrigin
	@GetMapping("/viewshowsforscreendt/{screenname}/{searchdt}")
	public List<Show> getShowsForScreenDate(@PathVariable("screenname") String screenName, 
			@PathVariable("searchdt") @DateTimeFormat(pattern="yyyy-M-d") LocalDate searchDt, HttpServletRequest request ) throws ShowException{
		List<Show> shows = serviceObject.getShows(screenName, searchDt);
		return shows;
		
	}
	
/*********************************************************************************************************************************
	 * Method: getShowsForMovieDt
     *Description: To search a show based on input of movie id and date from user. 
	 * @param movieid              - movie id for which the shows are to be searched.
	 * @param searchdt              - Date at which show is to be shown.
	 * @returns showList       - all shows whose criteria matches input given by user.
	 * @throws ShowException - When the user searched for a screen that does have any shows in database, exception is thrown. 
                *Created By         -Poojith
                *Created Date       - 04-SEP-2020                          	 
**********************************************************************************************************************************/
	@CrossOrigin
	@GetMapping("/viewshowsfordatemovieid/{movieid}/{searchdt}")
	public List<Show> getShowsForMovieDt( @PathVariable("movieid") int movieid ,
			@PathVariable("searchdt") @DateTimeFormat(pattern="yyyy-M-d") LocalDate searchDt, HttpServletRequest request  ) throws ShowException{
		List<Show> shows = serviceObject.getShows(searchDt, movieid);
		return shows;
		
	}
}
