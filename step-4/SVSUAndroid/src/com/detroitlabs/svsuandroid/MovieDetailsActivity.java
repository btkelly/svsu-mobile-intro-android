package com.detroitlabs.svsuandroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MovieDetailsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.movie_details);
		
		//Retrieve the movie you would like to display from the intent that was used to launch this activity
		Movie movie = getIntent().getParcelableExtra("movie");
		
		//Get references to the TextViews we want to bind data to and call setText with the information from the movie object
		((TextView)findViewById(R.id.title)).setText(movie.getTitle());
		((TextView)findViewById(R.id.genre)).setText("Genre: " + movie.getGenre());
		((TextView)findViewById(R.id.director)).setText("Dir: " + movie.getDirector());
		((TextView)findViewById(R.id.runtime)).setText("Runtime: " + movie.getRuntime() + " mins");
		((TextView)findViewById(R.id.year)).setText("Released: " + movie.getYear());
		
		//Create a new standard array adapter passing in the stars for this movie and the XML layout simple_list_item_1
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, movie.getStars());
		
		//Get a reference to the ListView and set the adapter to the adapter created above
		((ListView)findViewById(R.id.starsList)).setAdapter(adapter);
		
	}

}
