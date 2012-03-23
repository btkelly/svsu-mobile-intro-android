package com.detroitlabs.svsuandroid;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

public class MoviesFetcher {

	public static List<Movie> getMovies(Context context) throws IOException, JSONException{
		List<Movie> movies = new ArrayList<Movie>();		

		//Open movies.json file and read contents into a byte array		
		InputStream jsonData = context.getAssets().open("movies.json");
		int size = jsonData.available();

        byte[] buffer = new byte[size];
        jsonData.read(buffer);
        jsonData.close();
        
        //Turn byte array into a String which can be passed into the JSONArray constructor
        JSONArray movieJson = new JSONArray(new String(buffer));
		
        //Loop through all JSONObjects contained in the JSONArray
        for(int index = 0; index < movieJson.length(); index++) {
        	JSONObject singleMovie = (JSONObject) movieJson.get(index);
        	
        	Movie movie = new Movie();
        	
        	//Parse out the information from the JSON and fill a new movie model object
        	movie.setDirector(singleMovie.optString("director", ""));
        	movie.setGenre(singleMovie.optString("genre", ""));
        	movie.setRuntime(singleMovie.optInt("runtime", -1));
        	movie.setTitle(singleMovie.optString("title", ""));
        	movie.setYear(singleMovie.optInt("year", -1));
        	
        	JSONArray starsJson = singleMovie.optJSONArray("stars");
        	
        	List<String> stars = new ArrayList<String>();
        	
    		for(int index2 = 0; index2 < starsJson.length(); index2++) {
    			stars.add(starsJson.optString(index2));
    		}
    		
    		//Add the newly created movie model to the list of movies
    		movies.add(movie);    			
        }
		
        //Return the complete list of movies that was read from the JSON
		return movies;
	}
	
}
