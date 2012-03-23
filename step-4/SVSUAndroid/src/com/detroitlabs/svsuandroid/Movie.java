package com.detroitlabs.svsuandroid;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable{
	
	private String director, genre, title;
	private int year, runtime;
	private List<String> stars = new ArrayList<String>();
	
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
	
	public Movie(Parcel in) {
		title = in.readString();
		genre = in.readString();
		director = in.readString();
		runtime = in.readInt();
		year = in.readInt();
		in.readList(stars, Movie.class.getClassLoader());
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel out, int flags) {
		out.writeString(title);
		out.writeString(genre);
		out.writeString(director);
		out.writeInt(runtime);
		out.writeInt(year);
		out.writeList(stars);
	}

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

}
