package com.yuanzi.ting.mvpframework.mvp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yuanzi.ting.corelibrary.GradleTest;
import com.yuanzi.ting.mvpframework.R;
import com.yuanzi.ting.mvpframework.mvp.MvpActivity;
import com.yuanzi.ting.mvpframework.mvp.model.CircleResponse;
import com.yuanzi.ting.mvpframework.mvp.presenter.MainPresenter;
import com.yuanzi.ting.mvpframework.mvp.view.MainView;

import retrofit2.Retrofit;

public class MainActivity extends MvpActivity<MainPresenter> implements MainView {
    private TextView textView;
    private Button button;
    private EditText editText;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sayHello();

        GradleTest gradleTest = new GradleTest();
        gradleTest.display();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMvpPresenter.loadCircle();

            }
        });

    }

    public void sayHello() {
        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        image = (ImageView) findViewById(R.id.image);
    }

    @Override
    protected void onPause() {

    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void getDataSuccess(CircleResponse response) {
        Log.i("TAGGG", response.getCircles().get(0).getName());
        Glide.with(this).load(response.getCircles().get(0).getCover()).into(image);
    }

    @Override
    public void getDataFail(String msg) {
        Log.i("TAGGG", msg);
    }
}
