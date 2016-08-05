package com.icogroup.androidbaseproject.data.interactors.facebook;

import android.app.Activity;

import com.facebook.CallbackManager;
import com.icogroup.androidbaseproject.data.entity.User;

/**
 * Created by Ulises.harris on 8/5/16.
 */
public interface FacebookProvider {

    interface Interactor{
        void facebookLogin(Activity activity, CallbackManager callbackManager);
    }

    interface DataOutput{
        void facebookSuccess(User user);

        void facebookFailed(String error);
    }
}
