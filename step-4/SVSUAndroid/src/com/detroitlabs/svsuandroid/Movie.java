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
	
	/***************** Parcelable Section ***********************/
	
	/**
	 * Constructor that takes a Parcel to reconstruct the object from the Parcel.
	 * The order in which the variables are read must match the order in which they were written in writeToParcel.
	 * @param in
	 */
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
		//Return zero to tell Android that this Parcel will only contain this object
		return 0;
	}

	/**
	 * A function called by the Android system to turn this object into a Parcel for passing inside of Intent extras.
	 * The order of which the variables are written must match the order in which they are read in the constructor above.
	 */
	@Override
	public void writeToParcel(Parcel out, int flags) {
		out.writeString(title);
		out.writeString(genre);
		out.writeString(director);
		out.writeInt(runtime);
		out.writeInt(year);
		out.writeList(stars);
	}

	//A static variable called CREATOR that the Android system will call when the object should be recreated from its Parcel
    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
	
	/***************** End Parcelable Section ********************/

}
