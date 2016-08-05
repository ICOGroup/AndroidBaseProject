package com.icogroup.androidbaseproject.data.routing;

import android.app.Activity;
import android.content.Context;

import com.icogroup.androidbaseproject.data.entity.Movie;
import com.icogroup.androidbaseproject.data.entity.User;

/**
 * Created by Ulises.harris on 4/29/16.
 */
public interface IRouting {

    void movieDetail(Activity activity, Movie movie);

    void home(Activity activity, User user);

    void signUp(Activity activity);

    void login(Activity activity);
}
