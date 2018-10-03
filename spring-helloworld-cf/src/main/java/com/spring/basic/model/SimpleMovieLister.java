package com.spring.basic.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

@Component
public class SimpleMovieLister {
	
	private MovieFinder movieFinder;
	
	// Invalid Usage of Required
	/*@Required
	public SimpleMovieLister() {
		// TODO Auto-generated constructor stub
	}*/
	

	@Autowired
	@Required
	public void setMovieFinder(MovieFinder movieFinder) {
		System.err.println("setter() of SimpleMovieLister");
		this.movieFinder = movieFinder;
	}

}
