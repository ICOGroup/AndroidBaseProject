package com.icogroup.androidbaseproject.data.connection.interfaces;

import com.icogroup.androidbaseproject.data.entity.Movie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ulises.harris on 4/28/16.
 */
public interface MovieInterface {

    @GET("")
    Call<Movie> searchMovies(@Query("s") String search);
}
