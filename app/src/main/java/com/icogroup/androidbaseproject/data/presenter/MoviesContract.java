package com.icogroup.androidbaseproject.data.presenter;

import com.icogroup.androidbaseproject.data.entity.Movie;

import java.lang.reflect.Array;
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
    }
}
