package com.icogroup.androidbaseproject.data.sections.movie;

import com.icogroup.androidbaseproject.data.entity.Movie;

import java.util.ArrayList;

/**
 * Created by Ulises.harris on 4/28/16.
 */
public interface MoviesContract {

    interface View{
        void showMovies(ArrayList<Movie> movies);

        void showDialog();

        void showErrors(String message);

        void openMovieDetail(Movie movie);
    }

    interface MovieActionListener{

        void getMovies(String text);

        void openMovieDetail(Movie movie);
    }
}
