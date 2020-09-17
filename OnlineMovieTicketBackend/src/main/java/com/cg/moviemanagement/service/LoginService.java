package com.cg.moviemanagement.service;

import com.cg.moviemanagement.entities.User;
import com.cg.moviemanagement.exceptions.LoginException;


public interface LoginService {
	public User doLogin(int userId, String password) throws LoginException;

	public String encryptUser(User user);

}
