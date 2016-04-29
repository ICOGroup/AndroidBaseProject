package com.icogroup.androidbaseproject.data.sections.movie;

import com.icogroup.androidbaseproject.data.connection.repositories.movies.IMovieServices;
import com.icogroup.androidbaseproject.data.connection.repositories.movies.MovieServices;
import com.icogroup.androidbaseproject.data.entity.Movie;

import java.util.ArrayList;

/**
 * Created by Ulises.harris on 4/29/16.
 */
public class MoviesPresenter implements MoviesContract.MovieActionListener, IMovieServices {

    MovieServices mMovieServices;
    MoviesContract.View mView;

    public MoviesPresenter(MoviesContract.View view) {
        mView = view;

        mMovieServices = new MovieServices(this);
    }

    @Override
    public void getMovies(String text) {
        mMovieServices.searchMovie(text);
    }

    @Override
    public void openMovieDetail(Movie movie) {
        mView.openMovieDetail(movie);
    }

    @Override
    public void onGetMoviesSuccess(ArrayList<Movie> movies) {
        mView.showMovies(movies);
    }

    @Override
    public void onGetMoviesFailed(String error) {
        mView.showErrors(error);
    }
}
