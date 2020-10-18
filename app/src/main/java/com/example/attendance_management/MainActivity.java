package com.example.attendance_management;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.toolbox.Volley;

class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextSize(60);
        paint.setColor(Color.CYAN); //첫줄 제목 색깔 청녹색
        Typeface t;
        t = Typeface.create(Typeface.DEFAULT_BOLD, Typeface.BOLD);
        paint.setTypeface(t);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("코로나바이러스 감염증 대응", 540, 600, paint); //첫화면 제목 첫줄

        paint.setColor(Color.BLUE); //둘째줄 제목 색깔 파란색
        canvas.drawText("자기지킴이 출석체크 시스템", 540, 680, paint); //첫화면 제목 둘째줄

        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.maskicon); //첫화면 마스크아이콘 삽입
        canvas.drawBitmap(b, 420, 220, null);

        Bitmap b2 = BitmapFactory.decodeResource(getResources(), R.drawable.kpu_logo); //첫화면 한국산업기술대로고 삽입
        Bitmap sb2 = Bitmap.createScaledBitmap(b2, 500, 200, false);
        canvas.drawBitmap(sb2, 280, 1200, null);
    }

}

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