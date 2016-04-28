package com.icogroup.androidbaseproject.data.connection;

import com.icogroup.androidbaseproject.data.entity.Movie;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ulises.harris on 4/28/16.
 */
public class MovieServices {

    public void searchMovie(String text){
        Call<Movie> call = ServiceHelper.getMovieInterface().searchMovies(text);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {

            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {

            }
        });
    }
}
