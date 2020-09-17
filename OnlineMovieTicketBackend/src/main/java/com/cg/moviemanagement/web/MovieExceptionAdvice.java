package com.cg.moviemanagement.web;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cg.moviemanagement.exceptions.BookingException;
import com.cg.moviemanagement.exceptions.MovieNotFoundException;
import com.cg.moviemanagement.exceptions.ShowException;


public class MovieExceptionAdvice {
	
	Logger logger = LoggerFactory.getLogger(MovieExceptionAdvice.class);

	@CrossOrigin
	@ExceptionHandler(value= {MovieNotFoundException.class, BookingException.class,ShowException.class})
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	public Map<String,String> handleException(Exception ex) {
		logger.error(ex.getMessage());;
		Map<String, String> map = new HashMap<>();
		map.put("message", ex.getMessage());
		return map;
	}
}
