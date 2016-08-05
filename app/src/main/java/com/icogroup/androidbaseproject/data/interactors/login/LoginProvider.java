package com.icogroup.androidbaseproject.data.interactors.login;

import com.icogroup.androidbaseproject.data.entity.User;

/**
 * Created by Ulises.harris on 8/4/16.
 */
public interface LoginProvider {

    interface Interactor{
        void login(String email, String password);
    }

    interface DataOutput{

        void loginSuccess(User user);

        void loginError(String error);
    }
}
