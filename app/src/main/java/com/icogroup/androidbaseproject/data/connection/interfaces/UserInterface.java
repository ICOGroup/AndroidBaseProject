package com.icogroup.androidbaseproject.data.connection.interfaces;

import com.icogroup.androidbaseproject.data.entity.User;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Ulises.harris on 8/4/16.
 */
public interface UserInterface {

    @POST("/login")
    Call<User> login(@Body HashMap<String, String> body);

    @POST("/register")
    Call<User> register(@Body HashMap<String, String> body);
}
