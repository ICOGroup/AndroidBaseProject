package com.icogroup.androidbaseproject.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.icogroup.androidbaseproject.R;
import com.icogroup.androidbaseproject.data.entity.User;
import com.icogroup.androidbaseproject.data.routing.BaseRouting;
import com.icogroup.androidbaseproject.data.sections.register.RegisterContract;
import com.icogroup.androidbaseproject.data.sections.register.RegisterPresenter;
import com.icogroup.androidbaseproject.util.UserUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends AppCompatActivity implements RegisterContract.View {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.nameLayout)
    TextInputLayout nameLayout;
    @BindView(R.id.surname)
    EditText surname;
    @BindView(R.id.surnameLayout)
    TextInputLayout surnameLayout;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.emailLayout)
    TextInputLayout emailLayout;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.passwordLayout)
    TextInputLayout passwordLayout;
    @BindView(R.id.container)
    NestedScrollView container;

    private RegisterContract.ActionListener mRegisterPresenter;
    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        mRegisterPresenter = new RegisterPresenter(this, new BaseRouting());
    }

    @Override
    protected void onDestroy() {
        mRegisterPresenter.destroy();
        super.onDestroy();
    }

    @OnClick({R.id.signUpBtn, R.id.facebookBtn, R.id.logInBtn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signUpBtn:
                String nameTxt = name.getText().toString().trim();
                String surnameTxt = surname.getText().toString().trim();
                String emailTxt = email.getText().toString().trim();
                String passwordTxt = password.getText().toString().trim();

                mRegisterPresenter.register(nameTxt, surnameTxt, emailTxt, passwordTxt);
                break;
            case R.id.facebookBtn:
                mRegisterPresenter.facebookLogin(this, callbackManager);
                break;
            case R.id.logInBtn:
                mRegisterPresenter.goLogIn(this);
                break;
        }
    }

    @Override
    public void registerSuccess(User user) {
        UserUtil.setUser(this, user);
        mRegisterPresenter.goHome(this, user);
    }

    @Override
    public void registerFailed(String error) {
        Snackbar.make(container, error, Snackbar.LENGTH_LONG);
    }

    @Override
    public void validateError(int type) {
        switch (type) {
            case 0:
                nameLayout.setError(getString(R.string.empty_field));
                nameLayout.requestFocus();
                break;
            case 1:
                surnameLayout.setError(getString(R.string.empty_field));
                surnameLayout.requestFocus();
                break;
            case 2:
                emailLayout.setError(getString(R.string.empty_field));
                emailLayout.requestFocus();
                break;
            case 3:
                emailLayout.setError(getString(R.string.invalid_email));
                emailLayout.requestFocus();
                break;
            case 4:
                passwordLayout.setError(getString(R.string.invalid_email));
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
