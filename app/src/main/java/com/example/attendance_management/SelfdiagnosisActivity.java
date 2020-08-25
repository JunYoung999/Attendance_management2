package com.example.attendance_management;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.MotionEvent;
import androidx.appcompat.app.AppCompatActivity;

public class SelfdiagnosisActivity extends AppCompatActivity {
    Button coughYes, coughNo, throughYes, throughNo, headYes, headNo, highYes, highNo, noseYes, noseNo;
    int coughN = 0, throughN = 0, headN = 0, highN = 0, noseN=0, call_number;
    private TextView tv_name;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.selfdiagnosis_xml);

        tv_name=findViewById(R.id.tv_name5);

        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");

        tv_name.setText(userName);

        coughNo = findViewById(R.id.cough_no);
        coughYes = findViewById(R.id.cough_yes);
        throughNo = findViewById(R.id.through_no);
        throughYes = findViewById(R.id.through_yes);
        headNo = findViewById(R.id.head_no);
        headYes = findViewById(R.id.head_yes);
        highNo = findViewById(R.id.high_no);
        highYes = findViewById(R.id.high_yes);
        noseNo = findViewById(R.id.nose_no);
        noseYes = findViewById(R.id.nose_yes);

        coughYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                coughN = 1;
            }
        });
        coughYes.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN : view.setBackgroundColor(Color.RED); break;
                    case MotionEvent.ACTION_MOVE : view.setBackgroundColor(Color.RED); break;
                    case MotionEvent.ACTION_UP:  view.setBackgroundColor(Color.parseColor("#d3d3d3")); break;
                }
                return false;
            }
        });

        coughNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                coughN = 2;
            }
        });
        coughNo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN : view.setBackgroundColor(Color.GREEN); break;
                    case MotionEvent.ACTION_MOVE : view.setBackgroundColor(Color.GREEN); break;
                    case MotionEvent.ACTION_UP:  view.setBackgroundColor(Color.parseColor("#d3d3d3")); break;
                }
                return false;
            }
        });

        throughYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                throughN = 1;
            }
        });
        throughYes.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN : view.setBackgroundColor(Color.RED); break;
                    case MotionEvent.ACTION_MOVE : view.setBackgroundColor(Color.RED); break;
                    case MotionEvent.ACTION_UP:  view.setBackgroundColor(Color.parseColor("#d3d3d3")); break;
                }
                return false;
            }
        });

        throughNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                throughN = 2;
            }
        });
        throughNo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN : view.setBackgroundColor(Color.GREEN); break;
                    case MotionEvent.ACTION_MOVE : view.setBackgroundColor(Color.GREEN); break;
                    case MotionEvent.ACTION_UP:  view.setBackgroundColor(Color.parseColor("#d3d3d3")); break;
                }
                return false;
            }
        });

        headYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                headN = 1;
            }
        });
        headYes.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN : view.setBackgroundColor(Color.RED); break;
                    case MotionEvent.ACTION_MOVE : view.setBackgroundColor(Color.RED); break;
                    case MotionEvent.ACTION_UP:  view.setBackgroundColor(Color.parseColor("#d3d3d3")); break;
                }
                return false;
            }
        });

        headNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                headN=2;
            }
        });
        headNo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN : view.setBackgroundColor(Color.GREEN); break;
                    case MotionEvent.ACTION_MOVE : view.setBackgroundColor(Color.GREEN); break;
                    case MotionEvent.ACTION_UP:  view.setBackgroundColor(Color.parseColor("#d3d3d3")); break;
                }
                return false;
            }
        });

        highYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                highN = 1;
            }
        });
        highYes.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN : view.setBackgroundColor(Color.RED); break;
                    case MotionEvent.ACTION_MOVE : view.setBackgroundColor(Color.RED); break;
                    case MotionEvent.ACTION_UP:  view.setBackgroundColor(Color.parseColor("#d3d3d3")); break;
                }
                return false;
            }
        });

        highNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                highN = 2;
            }
        });
        highNo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN : view.setBackgroundColor(Color.GREEN); break;
                    case MotionEvent.ACTION_MOVE : view.setBackgroundColor(Color.GREEN); break;
                    case MotionEvent.ACTION_UP:  view.setBackgroundColor(Color.parseColor("#d3d3d3")); break;
                }
                return false;
            }
        });


        noseYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noseN = 1;
                Intent intent2 = getIntent();
                String userName = intent2.getStringExtra("userName");
                String userNumber = intent2.getStringExtra("userNumber");
                String userEmail = intent2.getStringExtra("userEmail");
                String userID = intent2.getStringExtra("userID");
                Intent intent = new Intent(getBaseContext(), ResultActivity.class);
                call_number++;
                intent.putExtra("cough", coughN);
                intent.putExtra("through" , throughN);
                intent.putExtra("head", headN);
                intent.putExtra("high", highN);
                intent.putExtra("nose", noseN);
                intent.putExtra("userName",userName);
                intent.putExtra("userNumber",userNumber);
                intent.putExtra( "userID", userID );
                intent.putExtra( "userEmail", userEmail );
                intent.putExtra("call_number",call_number);
                startActivity(intent);
            }
        });
        noseYes.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN : view.setBackgroundColor(Color.RED); break;
                    case MotionEvent.ACTION_MOVE : view.setBackgroundColor(Color.RED); break;
                    case MotionEvent.ACTION_UP:  view.setBackgroundColor(Color.parseColor("#d3d3d3")); break;
                }
                return false;
            }
        });
        noseNo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN : view.setBackgroundColor(Color.GREEN); break;
                    case MotionEvent.ACTION_MOVE : view.setBackgroundColor(Color.GREEN); break;
                    case MotionEvent.ACTION_UP:  view.setBackgroundColor(Color.parseColor("#d3d3d3")); break;
                }
                return false;
            }
        });

        noseNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noseN=2;
                if(highN == 2 && headN == 2 && throughN == 2 && coughN == 2){
                    Intent intent2 = getIntent();
                    String userName = intent2.getStringExtra("userName");
                    String userNumber = intent2.getStringExtra("userNumber");
                    String userEmail = intent2.getStringExtra("userEmail");
                    String userID = intent2.getStringExtra("userID");
                    Intent intent = new Intent(getBaseContext(), ResultActivity.class);
                    call_number=0;
                    intent.putExtra("cough", coughN);
                    intent.putExtra("through" , throughN);
                    intent.putExtra("head", headN);
                    intent.putExtra("high", highN);
                    intent.putExtra("nose", noseN);
                    intent.putExtra("userName",userName);
                    intent.putExtra("userNumber",userNumber);
                    intent.putExtra( "userID", userID );
                    intent.putExtra( "userEmail", userEmail );
                    intent.putExtra("call_number",call_number);
                    startActivity(intent);
                }else{
                    Intent intent2 = getIntent();
                    String userName = intent2.getStringExtra("userName");
                    String userNumber = intent2.getStringExtra("userNumber");
                    String userEmail = intent2.getStringExtra("userEmail");
                    String userID = intent2.getStringExtra("userID");
                    Intent intent = new Intent(getBaseContext(), ResultActivity.class);
                    call_number++;
                    intent.putExtra("cough", coughN);
                    intent.putExtra("through" , throughN);
                    intent.putExtra("head", headN);
                    intent.putExtra("high", highN);
                    intent.putExtra("nose", noseN);
                    intent.putExtra("userName",userName);
                    intent.putExtra("userNumber",userNumber);
                    intent.putExtra( "userID", userID );
                    intent.putExtra( "userEmail", userEmail );
                    intent.putExtra("call_number",call_number);
                    startActivity(intent);
                }
            }
        });
    }
}
