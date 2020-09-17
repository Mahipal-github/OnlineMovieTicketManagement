package com.cg.moviemanagement.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/*************************************************************************************************************************
*          @author         Arshad, Poojith,Mahipal 
*          Description      It is an entity class of Show, which maps to a database table lpu_movie_show, consists
*          				 of its private data members, setters and getters.
*         Version             1.0
*         Created Date    02-SEP-2020
************************************************************************************************************************/

@Entity
@Table(name="lpu_movie_user")
@DynamicUpdate
@DynamicInsert
public class User {
@Id
@Column(name="user_id")
	public int userId;
@Column(name="user_name", length=25)
	public String userName;
@Column(name="password", length=20)
	public String password;
@Column(name="role", length=20)
	public String role;
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}

}
