package com.detroitlabs.svsuandroid;

import java.util.List;

public class Movie {
	
	private String director, genre, title;
	private int year, runtime;
	private List<String> stars;
	
	public Movie(){
		
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public List<String> getStars() {
		return stars;
	}

	public void setStars(List<String> stars) {
		this.stars = stars;
	}
	
	@Override
	public String toString(){
		return "{ title = " + title + ", year = " + year + " }";
	}

}
