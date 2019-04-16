package com.example.mvvmdemo;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.mvvmdemo.callback.LoginResultCallBack;
import com.example.mvvmdemo.databinding.ActivityMainBinding;
import com.example.mvvmdemo.viewmodel.LoginViewFactory;
import com.example.mvvmdemo.viewmodel.LoginViewModel;

public class MainActivity extends AppCompatActivity implements LoginResultCallBack {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewmodel(ViewModelProviders.of(this,
                new LoginViewFactory(this)).
                get(LoginViewModel.class));
    }

    @Override
    public void onSucess(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFailure(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }


}
