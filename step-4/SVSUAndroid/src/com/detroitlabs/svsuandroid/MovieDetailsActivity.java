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
		
		Movie movie = getIntent().getParcelableExtra("movie");
		
		((TextView)findViewById(R.id.title)).setText(movie.getTitle());
		((TextView)findViewById(R.id.genre)).setText("Genre: " + movie.getGenre());
		((TextView)findViewById(R.id.director)).setText("Dir: " + movie.getDirector());
		((TextView)findViewById(R.id.runtime)).setText("Runtime: " + movie.getRuntime() + " mins");
		((TextView)findViewById(R.id.year)).setText("Released: " + movie.getYear());
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, movie.getStars());
		
		((ListView)findViewById(R.id.starsList)).setAdapter(adapter);
		
	}

}
