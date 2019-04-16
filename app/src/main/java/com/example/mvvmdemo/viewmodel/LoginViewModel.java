package com.example.mvvmdemo.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.example.mvvmdemo.callback.LoginResultCallBack;
import com.example.mvvmdemo.model.User;

public class LoginViewModel extends ViewModel {
    private User user;
    private LoginResultCallBack loginResultCallBack;

    public LoginViewModel(LoginResultCallBack loginResultCallBack) {
        this.loginResultCallBack = loginResultCallBack;
        this.user = new User();
    }

    //Write Method to get teh vcalue from teh Email and password editetxt and set to the user

    public TextWatcher getEmailTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                user.setEmail(s.toString());
            }
        };
    }

    public TextWatcher getpasswordTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                user.setPassword(s.toString());
            }
        };
    }

    public void onloginclicked(View view) {
        int errorocode = user.isValidData();
        switch (errorocode) {
            case 0:
                loginResultCallBack.onFailure("Email Feild is Empty");
                break;
            case 1:
                loginResultCallBack.onFailure("Email is not correct");
                break;
            case 2:
                loginResultCallBack.onFailure("Password  feild is Empty");
                break;
            case 3:
                loginResultCallBack.onFailure("The length of password is not correct");
                break;
            case -1:
                loginResultCallBack.onSucess("Login is Successfull");
                break;
        }

    }
}
