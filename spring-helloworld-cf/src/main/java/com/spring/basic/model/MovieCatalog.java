package com.spring.basic.model;

import java.util.List;

public class MovieCatalog {

	private List<MovieFinder> movies;
	
	private String movieName;
	
	public MovieCatalog(String movieNmae) {
		this.movieName = movieNmae;
	}
	
	public List<MovieFinder> getMovies() {
		return movies;
	}

	public void setMovies(List<MovieFinder> movies) {
		this.movies = movies;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	
}
