package com.icogroup.androidbaseproject.data.sections.register;

import android.app.Activity;

import com.facebook.CallbackManager;
import com.icogroup.androidbaseproject.data.entity.User;

/**
 * Created by Ulises.harris on 8/5/16.
 */
public interface RegisterContract {

    interface View{
        void registerSuccess(User user);

        void registerFailed(String error);

        void validateError(int type);
    }

    interface ActionListener{
        void register(String name, String surname, String email, String password);

        void destroy();

        void goHome(Activity activity, User user);

        void goLogIn(Activity activity);

        void facebookLogin(Activity activity, CallbackManager callbackManager);
    }
}
