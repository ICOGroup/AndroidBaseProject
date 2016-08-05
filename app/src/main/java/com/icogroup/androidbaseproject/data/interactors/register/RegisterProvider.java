package com.icogroup.androidbaseproject.data.interactors.register;

import com.icogroup.androidbaseproject.data.entity.User;

/**
 * Created by Ulises.harris on 8/5/16.
 */
public interface RegisterProvider {

    interface Interactor{
        void register(String name, String surname, String email, String password);
    }

    interface DataOutput{
        void registerSuccess(User user);

        void registerFailed(String error);
    }
}
