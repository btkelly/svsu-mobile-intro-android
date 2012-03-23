package com.detroitlabs.svsuandroid;

import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class MovieListActivity extends ListActivity implements OnItemClickListener{
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
        
        //Set item click listener on the ListView. Our activity implements the OnItemClickListener so we pass this as the listener.
        getListView().setOnItemClickListener(this);
    }

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		
		//Get the Movie object that represents the row that was clicked in the ListView
		Movie selectedMovie = (Movie) parent.getItemAtPosition(position);		

		//Create an Intent to launch the MovieDetailsActivity activity and add the selectedMovie as an extra
		Intent showDetails = new Intent(this, MovieDetailsActivity.class);
		showDetails.putExtra("movie", selectedMovie);
		startActivity(showDetails);
	}
}