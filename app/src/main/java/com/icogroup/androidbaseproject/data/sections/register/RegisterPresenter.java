package com.icogroup.androidbaseproject.data.sections.register;

import android.app.Activity;

import com.facebook.CallbackManager;
import com.icogroup.androidbaseproject.data.entity.User;
import com.icogroup.androidbaseproject.data.interactors.facebook.FacebookInteractor;
import com.icogroup.androidbaseproject.data.interactors.facebook.FacebookProvider;
import com.icogroup.androidbaseproject.data.interactors.register.RegisterInteractor;
import com.icogroup.androidbaseproject.data.interactors.register.RegisterProvider;
import com.icogroup.androidbaseproject.data.routing.IRouting;
import com.icogroup.androidbaseproject.util.StringUtil;

/**
 * Created by Ulises.harris on 8/5/16.
 */
public class RegisterPresenter implements RegisterContract.ActionListener, RegisterProvider
        .DataOutput, FacebookProvider.DataOutput {

    private FacebookInteractor facebookInteractor;
    private RegisterContract.View view;
    private IRouting router;
    private RegisterProvider.Interactor registerInteractor;

    public RegisterPresenter(RegisterContract.View view, IRouting router) {
        this.view = view;
        this.router = router;

        registerInteractor = new RegisterInteractor(this);
        facebookInteractor = new FacebookInteractor(this);
    }

    @Override
    public void register(String name, String surname, String email, String password) {
        if (view != null) {
            if (name.equals("")) {
                view.validateError(0);
                return;
            } else if (surname.equals("")) {
                view.validateError(1);
                return;
            } else if (email.equals("")) {
                view.validateError(2);
                return;
            } else if (!StringUtil.isValidEmail(email)) {
                view.validateError(3);
            } else if (password.equals("")) {
                view.validateError(4);
                return;
            }

            registerInteractor.register(name, surname, email, password);
        }
    }

    @Override
    public void destroy() {
        view = null;
    }

    @Override
    public void goHome(Activity activity, User user) {
        router.home(activity, user);
    }

    @Override
    public void goLogIn(Activity activity) {
        router.login(activity);
    }

    @Override
    public void facebookLogin(Activity activity, CallbackManager callbackManager) {
        facebookLogin(activity, callbackManager);
    }

    @Override
    public void registerSuccess(User user) {
        view.registerSuccess(user);
    }

    @Override
    public void registerFailed(String error) {
        view.registerFailed(error);
    }

    @Override
    public void facebookSuccess(User user) {
        view.registerSuccess(user);
    }

    @Override
    public void facebookFailed(String error) {
        view.registerFailed(error);
    }
}
