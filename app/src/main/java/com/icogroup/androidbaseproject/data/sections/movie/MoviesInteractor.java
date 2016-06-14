package com.icogroup.androidbaseproject.data.sections.movie;

import com.icogroup.androidbaseproject.data.connection.repositories.movies.MovieServices;
import com.icogroup.androidbaseproject.data.connection.repositories.movies.RepositoryListener;
import com.icogroup.androidbaseproject.data.entity.Movie;

import java.util.ArrayList;

/**
 * Created by Ulises.harris on 6/14/16.
 */
public class MoviesInteractor implements MoviesProvider.Interactor {

    private final MoviesProvider.DataOutput output;
    private final MovieServices mMovieServices;

    public MoviesInteractor(MoviesProvider.DataOutput output) {
        this.output = output;

        mMovieServices = new MovieServices();
    }

    @Override
    public void getMovies(String search) {
        mMovieServices.searchMovie(search, new RepositoryListener<ArrayList<Movie>>() {
            @Override
            public void onSuccess(ArrayList<Movie> response) {
                output.getMovies(response);
            }

            @Override
            public void onFailed(String error) {
                output.getError(error);
            }
        });
    }
}
