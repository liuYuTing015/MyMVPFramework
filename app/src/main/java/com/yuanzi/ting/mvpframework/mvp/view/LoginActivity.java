package com.yuanzi.ting.mvpframework.mvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yuanzi.ting.mvpframework.R;
import com.yuanzi.ting.mvpframework.base.BaseActivity;
import com.yuanzi.ting.mvpframework.base.BasePresenter;
import com.yuanzi.ting.mvpframework.mvp.MvpActivity;
import com.yuanzi.ting.mvpframework.mvp.model.CircleResponse;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}
