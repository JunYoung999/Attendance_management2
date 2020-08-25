package com.example.attendance_management;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    int coughN = 0, throughN = 0, headN = 0, highN = 0, noseN = 0, result_number=0;
    TextView cough, through, head, high, nose, tv_name;
    Button button,btn_emergencycall;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        final Intent intent = getIntent();

        tv_name=findViewById(R.id.tv_name7);

        String userName = intent.getStringExtra("userName");
        tv_name.setText(userName);

        coughN = intent.getIntExtra("cough", 0);
        throughN = intent.getIntExtra("through", 0);
        headN = intent.getIntExtra("head", 0);
        highN = intent.getIntExtra("high", 0);
        noseN = intent.getIntExtra("nose", 0);

        cough = findViewById(R.id.cough);
        through = findViewById(R.id.through);
        head = findViewById(R.id.head);
        high = findViewById(R.id.high);
        nose = findViewById(R.id.nose);

        button = findViewById(R.id.btn);
        btn_emergencycall=findViewById(R.id.btn_emergencycall3);

        if (coughN == 1) {
            cough.setText("네");
        } else {
            cough.setText("아니오");
        }
        if (throughN == 1) {
            through.setText("네");
        } else {
            through.setText("아니오");
        }

        if (headN == 1) {
            head.setText("네");
        } else {
            head.setText("아니오");
        }

        if (highN == 1) {
            high.setText("네");
        } else {
            high.setText("아니오");
        }

        if (noseN == 1) {
            nose.setText("네");
        } else {
            nose.setText("아니오");
        }
        Intent intent3=getIntent();
        int call_number = intent3.getIntExtra("call_number",0);
        if(call_number==0) {
            btn_emergencycall.setVisibility(View.GONE);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //TODO
                    Intent intent2 = getIntent();
                    String userName = intent2.getStringExtra("userName");
                    String userNumber = intent2.getStringExtra("userNumber");
                    String userEmail = intent2.getStringExtra("userEmail");
                    String userID = intent2.getStringExtra("userID");
                    Intent intent1 = new Intent(getBaseContext(), HomeActivity.class);
                    result_number++;
                    intent1.putExtra("result_number", result_number);
                    intent1.putExtra("userName", userName);
                    intent1.putExtra("userNumber", userNumber);
                    intent1.putExtra("userID", userID);
                    intent1.putExtra("userEmail", userEmail);
                    startActivity(intent1);
                }
            });
        }else if(call_number==1){
            button.setVisibility(View.GONE);
            btn_emergencycall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent2 = getIntent();
                    String userName = intent2.getStringExtra("userName");
                    String userNumber = intent2.getStringExtra("userNumber");
                    String userEmail = intent2.getStringExtra("userEmail");
                    String userID = intent2.getStringExtra("userID");
                    Intent intent1 = new Intent(getBaseContext(), Emergencycall.class);
                    intent1.putExtra("result_number", result_number);
                    intent1.putExtra("userName", userName);
                    intent1.putExtra("userNumber", userNumber);
                    intent1.putExtra("userID", userID);
                    intent1.putExtra("userEmail", userEmail);
                    startActivity(intent1);
                }
            });

        }

    }
}
