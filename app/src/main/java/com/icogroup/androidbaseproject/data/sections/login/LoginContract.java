package com.icogroup.androidbaseproject.data.sections.login;

import android.app.Activity;

import com.facebook.CallbackManager;
import com.icogroup.androidbaseproject.data.entity.User;

/**
 * Created by Ulises.harris on 8/4/16.
 */
public interface LoginContract {

    interface View{
        void loginSuccess(User user);

        void loginError(String error);

        void validationError(int type);

    }

    interface ActionListener{
        void login(String email, String password);

        void facebookLogin(Activity activity, CallbackManager callbackManager);

        void destroy();

        void goHome(Activity activity, User user);

        void goSignUp(Activity activity);
    }
}
