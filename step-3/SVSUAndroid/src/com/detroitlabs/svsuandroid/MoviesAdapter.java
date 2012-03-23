package com.detroitlabs.svsuandroid;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MoviesAdapter extends ArrayAdapter<Movie> {
	
	LayoutInflater inflater;

	public MoviesAdapter(Context context, List<Movie> movies) {
		super(context, android.R.layout.simple_list_item_2, movies);
		
		//Get the LayoutInflater service using the context object
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		//Check if the convertView is null and inflate a new view if it is
		if(convertView == null) {
			
			//Inflates an XML layout file called simple_list_item_2 which is part of the Android framework
			convertView = inflater.inflate(android.R.layout.simple_list_item_2, null); 
		}
		
		//Call getItem using the position passed into this function to retrieve the current Movie object
		Movie movie = getItem(position);
		
		//Get references to the views you want to bind data to
		TextView movieTitle = (TextView)convertView.findViewById(android.R.id.text1);
		TextView movieInfo = (TextView)convertView.findViewById(android.R.id.text2);
		
		//Bind the data from the Movie object to the TextView's for that row
		movieTitle.setText(movie.getTitle());
		movieInfo.setText(movie.getYear() + ", Dir: " + movie.getDirector());
		
		//Return the view to be displayed in the list
		return convertView;
	}
	

}
