package com.example.mvvmdemo.callback;

public interface LoginResultCallBack {
    void onSucess(String message);

    void onFailure(String message);
}
