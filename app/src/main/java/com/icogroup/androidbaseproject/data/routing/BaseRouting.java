package com.icogroup.androidbaseproject.data.routing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.icogroup.androidbaseproject.data.entity.Movie;
import com.icogroup.androidbaseproject.data.entity.User;
import com.icogroup.androidbaseproject.data.sections.login.LoginContract;
import com.icogroup.androidbaseproject.ui.activities.LoginActivity;
import com.icogroup.androidbaseproject.ui.activities.MainActivity;
import com.icogroup.androidbaseproject.ui.activities.MovieDetailActivity;
import com.icogroup.androidbaseproject.ui.activities.SignUpActivity;

/**
 * Created by Ulises.harris on 4/29/16.
 */
public class BaseRouting implements IRouting{

    public static String MOVIE_DETAIL_EXTRA = "movie_extra";
    public static String HOME_EXTRA = "user_extra";

    @Override
    public void movieDetail(Activity activity, Movie movie) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(MOVIE_DETAIL_EXTRA, movie);
        startActivity(activity, MovieDetailActivity.class, bundle);
    }

    @Override
    public void home(Activity activity, User user) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(HOME_EXTRA, user);
        startActivityFinish(activity, MainActivity.class, bundle);
    }

    @Override
    public void signUp(Activity activity) {
        startActivityFinish(activity, SignUpActivity.class);
    }

    @Override
    public void login(Activity activity) {
        startActivityFinish(activity, LoginActivity.class);
    }


    public void startActivity(Activity activity, Class clazz){
        Intent intent = new Intent(activity, clazz);
        activity.startActivity(intent);
    }

    public void startActivityTopClear(Context context,  Class clazz){
        Intent intent = new Intent(context, clazz);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

    }

    public void startActivityFinish(Activity activity,  Class clazz){
        Intent intent = new Intent(activity, clazz);
        activity.startActivity(intent);
        activity.finish();
    }

    public void startActivityFinish(Activity activity,  Class clazz, Bundle bundle){
        Intent intent = new Intent(activity, clazz);
        intent.putExtras(bundle);
        activity.startActivity(intent);
        activity.finish();
    }

    public void startActivity(Activity activity,  Class clazz, Bundle bundle){
        Intent intent = new Intent(activity, clazz);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

}
