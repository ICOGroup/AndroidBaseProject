package com.icogroup.androidbaseproject.data.interactors.movie;

import com.icogroup.androidbaseproject.data.connection.repositories.movies.MovieServices;
import com.icogroup.androidbaseproject.data.entity.Search;

import java.util.ArrayList;

import rx.Observable;

/**
 * Created by Ulises.harris on 6/14/16.
 */
public class MoviesInteractor implements MoviesProvider.Interactor {

    private final MovieServices mMovieServices;

    public MoviesInteractor() {

        mMovieServices = new MovieServices();
    }

    @Override
    public Observable<Search> getMovies(String search) {
        return mMovieServices.searchMovie(search);
    }
}
