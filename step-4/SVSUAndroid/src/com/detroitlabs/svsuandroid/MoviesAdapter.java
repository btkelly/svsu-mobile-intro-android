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
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null) {
			convertView = inflater.inflate(android.R.layout.simple_list_item_2, null); 
		}
		
		Movie movie = getItem(position);

		TextView movieTitle = (TextView)convertView.findViewById(android.R.id.text1);
		TextView movieInfo = (TextView)convertView.findViewById(android.R.id.text2);
		
		movieTitle.setText(movie.getTitle());
		movieInfo.setText(movie.getYear() + ", Dir: " + movie.getDirector());
		
		return convertView;
	}
	

}
