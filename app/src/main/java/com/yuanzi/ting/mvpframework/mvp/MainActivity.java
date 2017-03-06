package com.yuanzi.ting.mvpframework.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.yuanzi.ting.corelibrary.GradleTest;
import com.yuanzi.ting.mvpframework.R;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button button;
    private EditText editText;

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
                String name = editText.getText().toString();
                textView.setText("Hello," + name + "!");
            }
        });

    }

    public void sayHello() {
        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
    }

    @Override
    protected void onPause() {
        
    }
}
