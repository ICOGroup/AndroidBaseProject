package com.icogroup.androidbaseproject.data.connection.repositories;

import com.icogroup.androidbaseproject.data.entity.Movie;

import java.util.ArrayList;

/**
 * Created by Ulises.harris on 4/29/16.
 */
public interface RepositoryListener<T> {

    void onSuccess(T response);

    void onFailed(String error);
}