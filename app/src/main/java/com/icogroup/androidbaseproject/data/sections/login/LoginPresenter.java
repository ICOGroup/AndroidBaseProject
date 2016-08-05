package com.icogroup.androidbaseproject.data.sections.login;

import android.app.Activity;

import com.facebook.CallbackManager;
import com.icogroup.androidbaseproject.data.entity.User;
import com.icogroup.androidbaseproject.data.interactors.facebook.FacebookInteractor;
import com.icogroup.androidbaseproject.data.interactors.facebook.FacebookProvider;
import com.icogroup.androidbaseproject.data.interactors.login.LoginInteractor;
import com.icogroup.androidbaseproject.data.interactors.login.LoginProvider;
import com.icogroup.androidbaseproject.data.routing.IRouting;
import com.icogroup.androidbaseproject.util.StringUtil;

/**
 * Created by Ulises.harris on 8/4/16.
 */
public class LoginPresenter implements LoginContract.ActionListener, LoginProvider.DataOutput, FacebookProvider.DataOutput {

    private final FacebookInteractor facebookInteractor;
    private LoginProvider.Interactor loginInteractor;
    private LoginContract.View view;
    private IRouting router;

    public LoginPresenter(LoginContract.View view, IRouting router) {
        this.view = view;
        this.router = router;

        loginInteractor = new LoginInteractor(this);
        facebookInteractor = new FacebookInteractor(this);
    }

    @Override
    public void login(String email, String password) {
        if(view != null){
            if(email.equals("")){
                view.validationError(0);
                return;
            }else if(!StringUtil.isValidEmail(email)){
                view.validationError(1);
                return;
            }else if(password.equals("")){
                view.validationError(2);
                return;
            }

            loginInteractor.login(email, password);
        }
    }

    @Override
    public void facebookLogin(Activity activity, CallbackManager callbackManager) {
        facebookInteractor.facebookLogin(activity, callbackManager);
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
    public void goSignUp(Activity activity) {
        router.signUp(activity);
    }

    @Override
    public void loginSuccess(User user) {
        view.loginSuccess(user);
    }

    @Override
    public void loginError(String error) {
        view.loginError(error);
    }

    @Override
    public void facebookSuccess(User user) {
        view.loginSuccess(user);
    }

    @Override
    public void facebookFailed(String error) {
        view.loginError(error);
    }
}
