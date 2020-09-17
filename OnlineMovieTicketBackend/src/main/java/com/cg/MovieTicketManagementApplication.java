package com.cg;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cg.moviemanagement.entities.User;
import com.cg.moviemanagement.web.LoginInterceptor;

@SpringBootApplication
public class MovieTicketManagementApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(MovieTicketManagementApplication.class, args);
	}
	
	@Bean(name = "authenticatemap")
	public Map<String, User> getAuthenticateMap() {
		return new HashMap<>();
	}

	@Autowired
	public LoginInterceptor loginInterceptor;


	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor)
				.addPathPatterns(new String[] { "/cancelbooking/*", "/booking", "/addmovie",
						"/viewmovies", "/viewnewmovies", "/searchmovie/*",
						"/showsforscreen/*", "/viewshowsforscreenmoviedt/*", "/viewshowsforscreendt/*","/viewshowsfordatemovieid/*",
						"/viewshows/*","/viewscreen/*", "getbooking/*"});
	}
}
