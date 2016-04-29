package com.icogroup.androidbaseproject.data.connection.repositories.movies;

import com.icogroup.androidbaseproject.data.connection.ServiceHelper;
import com.icogroup.androidbaseproject.data.entity.Movie;
import com.icogroup.androidbaseproject.data.entity.Search;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ulises.harris on 4/28/16.
 */
public class MovieServices {


    private IMovieServices callback;

    public MovieServices(IMovieServices callback) {
        this.callback = callback;
    }

    public void searchMovie(String text){
        Call<Search> call = ServiceHelper.getMovieInterface().searchMovies(text);
        call.enqueue(new Callback<Search>() {
            @Override
            public void onResponse(Call<Search> call, Response<Search> response) {
                callback.onGetMoviesSuccess(response.body().getSearch());
            }

            @Override
            public void onFailure(Call<Search> call, Throwable t) {
                callback.onGetMoviesFailed(t.getMessage());
            }
        });

    }
}
