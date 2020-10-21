package com.dps0340.attman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
        //setContentView(R.layout.activity_main);
    }

    public boolean onTouchEvent(MotionEvent event) { //터치시 다음화면인 로그인화면으로 이동
        int action = event.getAction();
        if (action == MotionEvent.ACTION_DOWN) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }
        return super.onTouchEvent(event);
    }
}