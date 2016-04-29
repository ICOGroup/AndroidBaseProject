package com.icogroup.androidbaseproject.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.icogroup.androidbaseproject.R;
import com.icogroup.androidbaseproject.data.entity.Movie;
import com.icogroup.androidbaseproject.data.routing.BaseRouting;
import com.icogroup.androidbaseproject.data.sections.movie.MoviesContract;
import com.icogroup.androidbaseproject.data.sections.movie.MoviesPresenter;
import com.icogroup.androidbaseproject.ui.viewHolders.MovieViewHolder;
import com.icogroup.androidbaseproject.util.AppUtil;

import java.util.ArrayList;

import io.github.prashantsolanki3.snaplibrary.snap.SnapAdapter;
import io.github.prashantsolanki3.snaplibrary.snap.recycler.SnapOnItemClickListener;


public class MainActivity extends AppCompatActivity implements MoviesContract.View, SearchView
        .OnQueryTextListener {

    private RecyclerView mMoviesRecycler;
    SnapAdapter<Movie, MovieViewHolder> adapter;
    private MenuItem searchMenuItem;
    private SearchView mSearchView;
    private MoviesContract.MovieActionListener mMovieListener;
    private ArrayList<Movie> mMovies;
    private BaseRouting mBaseRouting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        init();

    }

    private void init() {
        mMoviesRecycler = (RecyclerView) findViewById(R.id.movies_recycler_view);
        mMoviesRecycler.setLayoutManager(new LinearLayoutManager(this));

        adapter = new SnapAdapter<>
                (this, Movie.class, R.layout.movie_item, MovieViewHolder.class);



        mMoviesRecycler.setAdapter(adapter);

        adapter.setRecyclerView(mMoviesRecycler);

        adapter.setOnItemClickListener(new SnapOnItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                mMovieListener.openMovieDetail(mMovies.get(i));
            }
        });

        mMovieListener = new MoviesPresenter(this);
        mBaseRouting = new BaseRouting();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        searchMenuItem = menu.findItem(R.id.action_search);
        mSearchView = (SearchView) searchMenuItem.getActionView();
        mSearchView.setOnQueryTextListener(this);
        return true;

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        return true;
    }

    @Override
    public void showMovies(ArrayList<Movie> movies) {
        mMovies = movies;
        adapter.set(movies);

    }

    @Override
    public void showDialog() {

    }

    @Override
    public void showErrors(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void openMovieDetail(Movie movie) {
        mBaseRouting.movieDetail(this, this, movie);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        if (query.equals("")) {
            return false;
        } else {
            AppUtil.hideKeyboard(this);
            mMovieListener.getMovies(query.trim());
            return true;
        }

    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
