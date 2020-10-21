package com.dps0340.attman;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AttendancecheckActivity extends AppCompatActivity{

    private Button btn_qrcodescan, btn_attendancestatus;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.attendancecheck_xml);

        //버튼클릭시 qr코드 스캔화면으로 넘어가는 기능
        btn_qrcodescan=findViewById(R.id.btn_qrcodescan);
        btn_qrcodescan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = getIntent();
                String userName = intent2.getStringExtra("userName");
                String userNumber = intent2.getStringExtra("userNumber");
                String userEmail = intent2.getStringExtra("userEmail");
                String userID = intent2.getStringExtra("userID");
                Intent intent = new Intent(AttendancecheckActivity.this,QrcodescanActivity.class);
                intent.putExtra("userName",userName);
                intent.putExtra("userNumber",userNumber);
                intent.putExtra( "userID", userID );
                intent.putExtra( "userEmail", userEmail );
                startActivity(intent);
            }
        });

        //버튼클릭시 출석현황 화면으로 넘어가는 기능
        btn_attendancestatus=findViewById(R.id.btn_attendancestatus);
        btn_attendancestatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = getIntent();
                String userName = intent2.getStringExtra("userName");
                String userNumber = intent2.getStringExtra("userNumber");
                String userEmail = intent2.getStringExtra("userEmail");
                String userID = intent2.getStringExtra("userID");
                String attendanceInformation = intent2.getStringExtra("attendanceInformation");
                String time = intent2.getStringExtra("time");
                int count = intent2.getIntExtra("count",0);
                Intent intent = new Intent(AttendancecheckActivity.this,AttendancestatusActivity.class);
                intent.putExtra("userName",userName);
                intent.putExtra("userNumber",userNumber);
                intent.putExtra( "userID", userID );
                intent.putExtra( "userEmail", userEmail );
                intent.putExtra("attendanceInformation",attendanceInformation);
                intent.putExtra("time",time);
                intent.putExtra("count",count);
                startActivity(intent);
            }
        });
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
        Intent intent = new Intent(AttendancecheckActivity.this,HomeActivity.class);
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
