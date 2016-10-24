package com.icogroup.androidbaseproject.data.connection.repositories.movies;

import com.icogroup.androidbaseproject.data.connection.ServiceHelper;
import com.icogroup.androidbaseproject.data.entity.Search;

import rx.Observable;

/**
 * Created by Ulises.harris on 4/28/16.
 */
public class MovieServices {

    public MovieServices() {

    }

    public Observable<Search> searchMovie(String text){
        return ServiceHelper.getInstance().getMovieInterface().searchMovies(text);
    }
}
