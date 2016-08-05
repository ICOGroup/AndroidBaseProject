package com.icogroup.androidbaseproject.data.interactors.facebook;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.icogroup.androidbaseproject.data.entity.User;
import com.icogroup.androidbaseproject.data.sections.register.RegisterContract;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

/**
 * Created by Ulises.harris on 8/5/16.
 */
public class FacebookInteractor implements FacebookProvider.Interactor{

    private FacebookProvider.DataOutput output;
    private LoginManager manager = LoginManager.getInstance();

    public FacebookInteractor(FacebookProvider.DataOutput output) {
        this.output = output;
    }

    @Override
    public void facebookLogin(Activity activity, CallbackManager callbackManager) {
        manager.logInWithReadPermissions(activity, Arrays.asList("email", "public_profile"));
        manager.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id, first_name, last_name, email"); // Parámetros que pedimos a facebook

                GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {

                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        if (response.getError() != null) {
                            // handle error
                            output.facebookFailed(response.getError().getErrorMessage());
                        } else {
                            try {

                                User user = new User();
                                user.setId(object.getString("id"));
                                user.setName(object.getString("first_name"));
                                user.setSurname(object.getString("last_name"));
                                user.setEmail(object.getString("email"));

                                output.facebookSuccess(user);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                });
                request.setParameters(parameters);
                request.executeAsync();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {
                output.facebookFailed(error.getLocalizedMessage());
            }
        });
    }
}
