package com.icogroup.androidbaseproject.data.connection.repositories.users;

import com.icogroup.androidbaseproject.data.connection.ServiceHelper;
import com.icogroup.androidbaseproject.data.connection.repositories.RepositoryListener;
import com.icogroup.androidbaseproject.data.entity.User;

import java.util.HashMap;
import java.util.Map;
import java.util.jar.Attributes;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ulises.harris on 8/5/16.
 */
public class UserRepository {

    public static final String NAME_PARAM = "name";
    public static final String SURNAME_PARAM = "surname";
    public static final String EMAIL_PARAM = "email";
    public static final String PASSWORD_PARAM = "password";

    public UserRepository() {
    }

    public void register(String name, String surname, String email, String password, final
    RepositoryListener<User> listener) {
        HashMap<String, String> body = new HashMap<>();
        body.put(NAME_PARAM, name);
        body.put(SURNAME_PARAM, surname);
        body.put(EMAIL_PARAM, email);
        body.put(PASSWORD_PARAM, password);

        Call<User> call = ServiceHelper.getInstance().getUserInterface().register(body);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                listener.onFailed(t.getLocalizedMessage());
            }
        });
    }

    public void login(String email, String password, final RepositoryListener<User> listener){
        HashMap<String, String> body = new HashMap<>();
        body.put(EMAIL_PARAM, email);
        body.put(PASSWORD_PARAM, password);

        Call<User> call = ServiceHelper.getInstance().getUserInterface().login(body);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                listener.onFailed(t.getLocalizedMessage());
            }
        });
    }
}
