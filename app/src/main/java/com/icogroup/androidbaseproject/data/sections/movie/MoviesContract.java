package com.icogroup.androidbaseproject.data.sections.movie;

import android.app.Activity;

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
    }

    interface MovieActionListener{

        void getMovies(String text);

        void onStop();

        void openMovieDetail(Activity activity, Movie movie);
    }
}
