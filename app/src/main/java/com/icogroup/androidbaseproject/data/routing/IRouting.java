package com.icogroup.androidbaseproject.data.routing;

import android.app.Activity;
import android.content.Context;

import com.icogroup.androidbaseproject.data.entity.Movie;

/**
 * Created by Ulises.harris on 4/29/16.
 */
public interface IRouting {

    void movieDetail(Activity activity, Context context, Movie movie);
}
