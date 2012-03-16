package com.detroitlabs.svsuandroid;

import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;

public class MovieListActivity extends ListActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_list);
        
        List<Movie> movies = null;
        
        try {
			movies = MoviesFetcher.getMovies(this);
		} catch (Exception e) {
			e.printStackTrace();
			finish();
			return;
		}
        
        Log.i("SVSUDemo", movies.toString());
        
        MoviesAdapter adapter = new MoviesAdapter(this, movies);
        setListAdapter(adapter);
    }
}