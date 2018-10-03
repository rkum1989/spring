package com.spring.basic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.spring.basic.model.MovieCatalog;

@Configuration
public class MovieConfiguration {

	@Bean
	@Primary
	public MovieCatalog firstMovieCatalog() {
		System.err.println("firstMovieCatalog");
		return new MovieCatalog("firstMovie Recommended");
	}

	@Bean
	public MovieCatalog secondMovieCatalog() {
		System.err.println("secondMovieCatalog");
		return new MovieCatalog("secondMovie Recommended");
	}

}
