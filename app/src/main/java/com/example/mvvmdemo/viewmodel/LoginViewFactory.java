package com.example.mvvmdemo.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.mvvmdemo.callback.LoginResultCallBack;

public class LoginViewFactory extends ViewModelProvider.NewInstanceFactory {
    public LoginResultCallBack loginResultCallBack;

    public LoginViewFactory(LoginResultCallBack loginResultCallBack){
        this.loginResultCallBack=loginResultCallBack;

    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T)new LoginViewModel(loginResultCallBack);
    }
}
