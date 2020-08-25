package com.example.attendance_management;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import androidx.appcompat.app.AppCompatActivity;

public class AttendancestatusActivity extends AppCompatActivity {

    //public static final String PREFS_NAME = "MyPrefs";
    private TextView tv_name,tv_number,tv_week,tv_day,tv_time,tv_attendanceInformation;
    //String attendanceInformation;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attendancestatus_xml);

        tv_name=findViewById(R.id.tv_name6);
        tv_number=findViewById(R.id.tv_number6);
        tv_week=findViewById(R.id.tv_week);
        tv_day=findViewById(R.id.tv_day);
        tv_time=findViewById(R.id.tv_time);
        tv_attendanceInformation=findViewById(R.id.tv_attendanceInformation);

        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        String userNumber = intent.getStringExtra("userNumber");
        String attendanceInformation = intent.getStringExtra("attendanceInformation");
        String time = intent.getStringExtra("time");
        int count = intent.getIntExtra("count",0);

        Date currenTime = Calendar.getInstance().getTime();
        String date_text = new SimpleDateFormat("EE요일", Locale.getDefault()).format(currenTime);

        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy-MM-dd");
        String formatData = sdfNow.format(date);

        Thread thread = new Thread() {

            @Override
            public void run() {
                while (!isInterrupted()) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Calendar calendar = Calendar.getInstance(); // 칼렌다 변수
                            int hour = calendar.get(Calendar.HOUR_OF_DAY); // 시
                            int minute = calendar.get(Calendar.MINUTE); // 분
                            int second = calendar.get(Calendar.SECOND); // 초
                            tv_time.setText("("+hour + ":" + minute + ":" + second+")"
                            );
                        }
                    });
                    try {
                        Thread.sleep(1000); // 1000 ms = 1초
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } // while
            } // run()
        }; // new Thread() { };

        thread.start();

        tv_name.setText(userName);
        tv_number.setText("["+userNumber+"]");
        tv_week.setText(date_text);
        tv_day.setText(formatData);
        tv_attendanceInformation.setText(attendanceInformation+"   "+time+" 출석완료"+count);

        //SharedPreferences settings = getSharedPreferences(PREFS_NAME,0);


    }

    //백버튼을 눌렀을때 기능
    public void onBackPressed() {
        Intent intent2 = getIntent();
        String userName = intent2.getStringExtra("userName");
        String userNumber = intent2.getStringExtra("userNumber");
        String userEmail = intent2.getStringExtra("userEmail");
        String userID = intent2.getStringExtra("userID");
        String attendanceInformation = intent2.getStringExtra("attendanceInformation");
        String time = intent2.getStringExtra("time");
        int count = intent2.getIntExtra("count",0);
        Intent intent = new Intent(AttendancestatusActivity.this,AttendancecheckActivity.class);
        intent.putExtra("userName",userName);
        intent.putExtra("userNumber",userNumber);
        intent.putExtra( "userID", userID );
        intent.putExtra( "userEmail", userEmail );
        intent.putExtra("attendanceInformation",attendanceInformation);
        intent.putExtra("time",time);
        intent.putExtra("count",count);
        startActivity(intent);
        super.onBackPressed();
    }
}
