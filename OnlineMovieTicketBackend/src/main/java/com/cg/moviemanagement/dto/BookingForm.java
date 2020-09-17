package com.cg.moviemanagement.dto;


/*************************************************************************************************************************
 * @author : Arshad, Poojith, Mahipal
 * Description : This is the dto class that generate messages by using in the controller methods.
 * Version : 1.0 
 * Created Date : 04-SEP-2020
*************************************************************************************************************************/

public class BookingForm {
	private int showId;
	private int tkts;
	private String userName;
	private String contact;

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public int getTkts() {
		return tkts;
	}

	public void setTkts(int tkts) {
		this.tkts = tkts;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}
