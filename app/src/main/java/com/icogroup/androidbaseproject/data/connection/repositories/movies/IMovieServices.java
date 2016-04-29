package com.icogroup.androidbaseproject.data.connection.repositories.movies;

import com.icogroup.androidbaseproject.data.entity.Movie;

import java.util.ArrayList;

/**
 * Created by Ulises.harris on 4/29/16.
 */
public interface IMovieServices {

    void onGetMoviesSuccess(ArrayList<Movie> movies);

    void onGetMoviesFailed(String error);
}
