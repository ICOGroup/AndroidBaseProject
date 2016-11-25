package com.icogroup.androidbaseproject.data.connection.interfaces;

import com.icogroup.androidbaseproject.data.entity.Search;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Ulises.harris on 4/28/16.
 */
public interface MovieInterface {

    @GET("/")
    Observable<Search> searchMovies(@Query("s") String search);
}
