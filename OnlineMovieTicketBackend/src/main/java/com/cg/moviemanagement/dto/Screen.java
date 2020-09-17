package com.cg.moviemanagement.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.cg.moviemanagement.entities.Movie;
import com.cg.moviemanagement.entities.Show;


/*************************************************************************************************************************
 * @author : Arshad, Poojith, Mahipal
 * Description : This is the dto class that generate messages by using in the controller methods.
 * Version : 1.0 
 * Created Date : 04-SEP-2020
*************************************************************************************************************************/

public class Screen {

	private Movie movie;
	private LocalDate showDate;
	private String screenName;
	private String screenImg;
	private String showNames;

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getShowNames() {
		return showNames;
	}

	public void setShowNames(String showNames) {
		this.showNames = showNames;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public LocalDate getShowDate() {
		return showDate;
	}

	public void setShowDate(LocalDate showDate) {
		this.showDate = showDate;
	}

	public String getScreenImg() {
		return screenImg;
	}

	public void setScreenImg(String screenImg) {
		this.screenImg = screenImg;
	}

}
