package com.example.attendance_management;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Emergencycall extends AppCompatActivity implements View.OnClickListener{

    private Button btn_call1, btn_call2, btn_call3, btn_call4, btn_call5; //전화를 바로 걸기위한 변수선언
    private Button btn_dialogcall1, btn_dialogcall2, btn_dialogcall3, btn_dialogcall4, btn_dialogcall5; //전화 다이얼로그를 위한 변수선언

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.emergencycall_xml);

        btn_call1=findViewById(R.id.btn_call1);
        btn_call2=findViewById(R.id.btn_call2);
        btn_call3=findViewById(R.id.btn_call3);
        btn_call4=findViewById(R.id.btn_call4);
        btn_call5=findViewById(R.id.btn_call5);

        btn_dialogcall1=findViewById(R.id.btn_dialogcall1);
        btn_dialogcall2=findViewById(R.id.btn_dialogcall2);
        btn_dialogcall3=findViewById(R.id.btn_dialogcall3);
        btn_dialogcall4=findViewById(R.id.btn_dialogcall4);
        btn_dialogcall5=findViewById(R.id.btn_dialogcall5);

       btn_call1.setOnClickListener(this);
       btn_dialogcall1.setOnClickListener(this);
       btn_call2.setOnClickListener(this);
       btn_dialogcall2.setOnClickListener(this);
       btn_call3.setOnClickListener(this);
       btn_dialogcall3.setOnClickListener(this);
       btn_call4.setOnClickListener(this);
       btn_dialogcall4.setOnClickListener(this);
       btn_call5.setOnClickListener(this);
       btn_dialogcall5.setOnClickListener(this);

    }

    //바로전화걸기와 전화 디이얼로그 기능을 수행하는 코드
    public void onClick(View view) {
        String tel1="tel:"+"1339";
        String tel2="tel:"+"031-310-5830";
        String tel3="tel:"+"031-310-5901";
        String tel4="tel:"+"031-8041-0086";
        String tel5="tel:"+"031-8041-1030";
        switch (view.getId()){
            case R.id.btn_call1:
                startActivity(new Intent("android.intent.action.CALL",Uri.parse(tel1)));
                break;
            case R.id.btn_dialogcall1:
                startActivity(new Intent("android.intent.action.DIAL",Uri.parse(tel1)));
                break;
            case R.id.btn_call2:
                startActivity(new Intent("android.intent.action.CALL",Uri.parse(tel2)));
                break;
            case R.id.btn_dialogcall2:
                startActivity(new Intent("android.intent.action.DIAL",Uri.parse(tel2)));
                break;
            case R.id.btn_call3:
                startActivity(new Intent("android.intent.action.CALL",Uri.parse(tel3)));
                break;
            case R.id.btn_dialogcall3:
                startActivity(new Intent("android.intent.action.DIAL",Uri.parse(tel3)));
                break;
            case R.id.btn_call4:
                startActivity(new Intent("android.intent.action.CALL",Uri.parse(tel4)));
                break;
            case R.id.btn_dialogcall4:
                startActivity(new Intent("android.intent.action.DIAL",Uri.parse(tel4)));
                break;
            case R.id.btn_call5:
                startActivity(new Intent("android.intent.action.CALL",Uri.parse(tel5)));
                break;
            case R.id.btn_dialogcall5:
                startActivity(new Intent("android.intent.action.DIAL",Uri.parse(tel5)));
                break;
        }
    }

    public void onBackPressed() {
        Intent intent2 = getIntent();
        String userName = intent2.getStringExtra("userName");
        String userNumber = intent2.getStringExtra("userNumber");
        String userEmail = intent2.getStringExtra("userEmail");
        String userID = intent2.getStringExtra("userID");
        int count = intent2.getIntExtra("count",0);
        Intent intent = new Intent(Emergencycall.this,HomeActivity.class);
        intent.putExtra("userName",userName);
        intent.putExtra("userNumber",userNumber);
        intent.putExtra( "userID", userID );
        intent.putExtra( "userEmail", userEmail );
        startActivity(intent);
        super.onBackPressed();
    }
}
