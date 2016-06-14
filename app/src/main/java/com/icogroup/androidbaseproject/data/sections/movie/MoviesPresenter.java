package com.icogroup.androidbaseproject.data.sections.movie;

import com.icogroup.androidbaseproject.data.entity.Movie;

import java.util.ArrayList;

/**
 * Created by Ulises.harris on 4/29/16.
 */
public class MoviesPresenter implements MoviesContract.MovieActionListener, MoviesProvider.DataOutput {

    private MoviesInteractor interactor;
    private MoviesContract.View mView;

    public MoviesPresenter(MoviesContract.View view) {
        mView = view;

        interactor = new MoviesInteractor(this);
    }

    @Override
    public void getMovies(String text) {
       interactor.getMovies(text);
    }

    @Override
    public void openMovieDetail(Movie movie) {
        mView.openMovieDetail(movie);
    }


    @Override
    public void getMovies(ArrayList<Movie> movies) {
        mView.showMovies(movies);
    }

    @Override
    public void getError(String error) {
        mView.showErrors(error);
    }
}
