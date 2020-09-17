package com.cg.moviemanagement.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.moviemanagement.entities.User;
import com.cg.moviemanagement.exceptions.LoginException;
import com.cg.moviemanagement.service.LoginService;

@RestController
public class LoginRestController {

	@Autowired
	private LoginService ser;

	
    @Autowired 
	@Qualifier("authenticatemap") 
	private Map<String, User> authMap;
    
	@CrossOrigin(origins = {"http://localhost:4200"})
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String getLogin(@RequestParam("userId") int userId, @RequestParam("password") String password) {
		String token=null;
		try {
		User user = ser.doLogin(userId, password);
		token = ser.encryptUser(user);
		authMap.put(token, user);
		
		}catch(LoginException e) {
			System.out.println(e.getMessage());
		}
		return token;
	}
	
	  @CrossOrigin(origins = {"http://localhost:4200"}) 
	  @RequestMapping(value = "/logout", method = RequestMethod.GET)
	  public String logout(@RequestHeader("userId") String token, HttpServletRequest req) {
	  authMap.remove(token); 
	  return "logged out"; 
	  }
	 

}
