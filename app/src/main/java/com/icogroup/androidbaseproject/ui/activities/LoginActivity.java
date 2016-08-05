package com.icogroup.androidbaseproject.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.icogroup.androidbaseproject.R;
import com.icogroup.androidbaseproject.data.entity.User;
import com.icogroup.androidbaseproject.data.routing.BaseRouting;
import com.icogroup.androidbaseproject.data.sections.login.LoginContract;
import com.icogroup.androidbaseproject.data.sections.login.LoginPresenter;
import com.icogroup.androidbaseproject.util.UserUtil;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.emailLayout)
    TextInputLayout emailLayout;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.passwordLayout)
    TextInputLayout passwordLayout;
    @BindView(R.id.facebookBtn)
    Button facebookBtn;
    @BindView(R.id.container)
    CoordinatorLayout container;
    private LoginContract.ActionListener mLoginPresenter;
    private CallbackManager callbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        mLoginPresenter = new LoginPresenter(this, new BaseRouting());

        User user = UserUtil.getUser(this);
        if(!user.getId().equals("")){
            mLoginPresenter.goHome(this, user);
        }

    }

    @Override
    protected void onDestroy() {
        mLoginPresenter.destroy();
        super.onDestroy();
    }

    @OnClick({R.id.logInBtn, R.id.facebookBtn, R.id.signUpBtn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.logInBtn:
                String emailTxt = email.getText().toString().trim();
                String passwordTxt = password.getText().toString().trim();
                mLoginPresenter.login(emailTxt, passwordTxt);
                break;
            case R.id.facebookBtn:
                mLoginPresenter.facebookLogin(this, callbackManager);
                break;
            case R.id.signUpBtn:
                mLoginPresenter.goSignUp(this);
                break;
        }
    }

    @Override
    public void loginSuccess(User user) {
        UserUtil.setUser(this, user);
        mLoginPresenter.goHome(this, user);
    }

    @Override
    public void loginError(String error) {
        Snackbar.make(container, error, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void validationError(int type) {
        switch (type) {
            case 0:
                emailLayout.setError(getString(R.string.empty_field));
                emailLayout.requestFocus();
                break;
            case 1:
                emailLayout.setError(getString(R.string.invalid_email));
                emailLayout.requestFocus();
                break;
            case 2:
                passwordLayout.setError(getString(R.string.empty_field));
                passwordLayout.requestFocus();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
