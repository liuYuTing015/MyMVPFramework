package com.yuanzi.ting.mvpframework.mvp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.yuanzi.ting.mvpframework. mvp.MvpActivity;
import com.yuanzi.ting.mvpframework.mvp.model.Circle;
import com.yuanzi.ting.mvpframework.mvp.model.CircleResponse;
import com.yuanzi.ting.mvpframework.mvp.model.MessageEvent;
import com.yuanzi.ting.mvpframework.mvp.presenter.MainPresenter;
import com.yuanzi.ting.mvpframework.mvp.view.MainView;
import com.yuanzi.ting.mvpframework.mvp.ui.MainAdapter.Type;
import com.yuanzi.ting.mvpframework.utils.GlideImageLoader;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import retrofit2.Retrofit;

public class MainActivity extends MvpActivity<MainPresenter> implements MainView {
    private TextView textView;
    private Button button;
    private EditText editText;
    private ImageView image;
    private ImageView image1;
    Circle circle;

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

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Circle circle = (Circle) view.getTag();
                EventBus.getDefault().post(circle);
            }
        });

//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
//
//        List<Type> dataSet = new ArrayList<>();
//        dataSet.add(Type.Mask);
//        dataSet.add(Type.NinePatchMask);
//        dataSet.add(Type.CropTop);
//        dataSet.add(Type.CropCenter);
//        dataSet.add(Type.CropBottom);
//        dataSet.add(Type.CropSquare);
//        dataSet.add(Type.CropCircle);
//        dataSet.add(Type.ColorFilter);
//        dataSet.add(Type.Grayscale);
//        dataSet.add(Type.RoundedCorners);
//        dataSet.add(Type.Blur);
//        dataSet.add(Type.Toon);
//        dataSet.add(Type.Sepia);
//        dataSet.add(Type.Contrast);
//        dataSet.add(Type.Invert);
//        dataSet.add(Type.Pixel);
//        dataSet.add(Type.Sketch);
//        dataSet.add(Type.Swirl);
//        dataSet.add(Type.Brightness);
//        dataSet.add(Type.Kuawahara);
//        dataSet.add(Type.Vignette);
//
//        recyclerView.setAdapter(new MainAdapter(this, dataSet));

    }

    public void sayHello() {
        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        image = (ImageView) findViewById(R.id.image);
        image1 = (ImageView) findViewById(R.id.image1);
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void getDataSuccess(CircleResponse response) {
        Log.i("TAGGG", response.getCircles().get(0).getName());
        Glide.with(this)
                .load(response.getCircles().get(0).getCover())
                .placeholder(R.drawable.leak_canary_icon)
                .crossFade()
                .into(image);
        image.setTag(response.getCircles().get(6));

//        GlideImageLoader.glideLoader(this, response.getCircles().get(0).getCover(), R.drawable.leak_canary_icon, R.drawable.leak_canary_icon, image, 0);
//        GlideImageLoader.glideLoader(this, response.getCircles().get(0).getCover(), R.drawable.leak_canary_icon, R.drawable.leak_canary_icon, image1, 1);
    }

    @Override
    public void getDataFail(String msg) {
        Log.i("TAGGG", msg);
    }

    @Subscribe
    public void onEvent(Circle circle) {
        // super.onEvent(event);
        Glide.with(this)
                .load(circle.getCover())
                .bitmapTransform(new CropCircleTransformation(this))
                .into(image1);
        // GlideImageLoader.glideLoader(MainActivity.this, circle.getCover(), R.drawable.leak_canary_icon, R.drawable.leak_canary_icon, image1, 1);


    }
}
