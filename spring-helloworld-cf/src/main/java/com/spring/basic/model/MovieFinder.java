package com.spring.basic.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MovieFinder {
	private String movieName;
	private List<String> actors;
	private String director;
	private String movieType;

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public List<String> getActors() {
		return actors;
	}

	public void setActors(List<String> actors) {
		this.actors = actors;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getMovieType() {
		return movieType;
	}

	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}

	@Override
	public String toString() {
		System.err.println("toString() of MovieFinder class");
		return String.format("MovieFinder [movieName=%s, actors=%s, director=%s, movieType=%s]", movieName, actors,
				director, movieType);
	}

}
