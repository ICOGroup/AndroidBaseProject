package com.icogroup.androidbaseproject.data.routing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.icogroup.androidbaseproject.data.entity.Movie;
import com.icogroup.androidbaseproject.ui.activities.MovieDetailActivity;

/**
 * Created by Ulises.harris on 4/29/16.
 */
public class BaseRouting implements IRouting{

    public static String MOVIE_DETAIL_EXTRA = "movie_extra";

    @Override
    public void movieDetail(Activity activity, Context context, Movie movie) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.putExtra(MOVIE_DETAIL_EXTRA, movie);
        activity.startActivity(intent);
    }

}
