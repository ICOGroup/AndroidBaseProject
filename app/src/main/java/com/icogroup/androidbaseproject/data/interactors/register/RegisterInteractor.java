package com.icogroup.androidbaseproject.data.interactors.register;

import com.icogroup.androidbaseproject.data.connection.repositories.RepositoryListener;
import com.icogroup.androidbaseproject.data.connection.repositories.movies.UserRepository;
import com.icogroup.androidbaseproject.data.entity.User;

/**
 * Created by Ulises.harris on 8/5/16.
 */
public class RegisterInteractor implements RegisterProvider.Interactor {

    private RegisterProvider.DataOutput output;
    private UserRepository repository;

    public RegisterInteractor(RegisterProvider.DataOutput output) {
        this.output = output;
        repository = new UserRepository();
    }

    @Override
    public void register(String name, String surname, String email, String password) {
        repository.register(name, surname, email, password, new RepositoryListener<User>() {
            @Override
            public void onSuccess(User response) {
                output.registerSuccess(response);
            }

            @Override
            public void onFailed(String error) {
                output.registerFailed(error);
            }
        });
    }
}
