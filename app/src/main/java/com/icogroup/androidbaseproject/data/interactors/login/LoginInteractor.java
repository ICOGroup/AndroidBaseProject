package com.icogroup.androidbaseproject.data.interactors.login;

import com.icogroup.androidbaseproject.data.connection.repositories.RepositoryListener;
import com.icogroup.androidbaseproject.data.connection.repositories.movies.UserRepository;
import com.icogroup.androidbaseproject.data.entity.User;

/**
 * Created by Ulises.harris on 8/4/16.
 */
public class LoginInteractor implements LoginProvider.Interactor {

    private UserRepository userRepository;
    private LoginProvider.DataOutput output;


    public LoginInteractor(LoginProvider.DataOutput output) {
        this.output = output;
        userRepository = new UserRepository();
    }

    @Override
    public void login(String email, String password) {
        userRepository.login(email, password, new RepositoryListener<User>() {
            @Override
            public void onSuccess(User response) {
                output.loginSuccess(response);
            }

            @Override
            public void onFailed(String error) {
                output.loginError(error);
            }
        });
    }
}
