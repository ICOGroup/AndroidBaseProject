package com.icogroup.androidbaseproject.data.interactors.movie;

import com.icogroup.androidbaseproject.data.entity.Movie;
import com.icogroup.androidbaseproject.data.entity.Search;

import java.util.ArrayList;

import rx.Observable;

/**
 * Created by Ulises.harris on 6/14/16.
 */
public interface MoviesProvider {

    interface Interactor{
        Observable<Search> getMovies(String search);
    }

}
