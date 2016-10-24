package com.icogroup.androidbaseproject.data.interactors.movie;

import com.icogroup.androidbaseproject.data.entity.Movie;

import java.util.ArrayList;

/**
 * Created by Ulises.harris on 6/14/16.
 */
public interface MoviesProvider {

    interface Interactor{
        void getMovies(String search);
    }

    interface DataOutput{
        void getMovies(ArrayList<Movie> movies);

        void getError(String error);
    }
}
