package com.icogroup.androidbaseproject.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.icogroup.androidbaseproject.R;
import com.icogroup.androidbaseproject.data.entity.Movie;
import com.icogroup.androidbaseproject.data.routing.BaseRouting;
import com.icogroup.androidbaseproject.data.sections.movie.MoviesContract;
import com.icogroup.androidbaseproject.data.sections.movie.MoviesPresenter;
import com.icogroup.androidbaseproject.ui.viewHolders.MovieViewHolder;
import com.icogroup.androidbaseproject.util.AppUtil;
import com.icogroup.icoadapter.recyclerview.BaseRecyclerViewAdapter;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements MoviesContract.View, SearchView
        .OnQueryTextListener {

    private RecyclerView mMoviesRecycler;
    BaseRecyclerViewAdapter<Movie, MovieViewHolder> adapter;
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

        adapter = new BaseRecyclerViewAdapter<Movie, MovieViewHolder>(this) {
            @Override
            protected MovieViewHolder onCreateItemView(LayoutInflater inflater, ViewGroup parent) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent,
                        false);
                return new MovieViewHolder(view, parent.getContext()) ;
            }
        };

        adapter.setOnItemClickListener(new BaseRecyclerViewAdapter.Listener<Movie>() {
            @Override
            public void onClickItem(Movie movie, View v, int position) {
                mMovieListener.openMovieDetail(mMovies.get(position));
            }
        });

        mMoviesRecycler.setAdapter(adapter);

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
        adapter.setAll(movies);

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
        mBaseRouting.movieDetail(this, movie);
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
