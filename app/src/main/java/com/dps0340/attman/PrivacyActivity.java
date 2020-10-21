package com.dps0340.attman;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PrivacyActivity extends AppCompatActivity {
    private TextView tv_name, tv_number, tv_email, tv_id;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.privacy_xml);

        tv_name=findViewById(R.id.tv_name3);
        tv_number=findViewById(R.id.tv_number3);
        tv_email=findViewById(R.id.tv_email3);
        tv_id=findViewById(R.id.tv_id3);

        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        String userNumber = intent.getStringExtra("userNumber");
        String userEmail= intent.getStringExtra("userEmail");
        String userID=intent.getStringExtra("userID");

        tv_name.setText(userName);
        tv_number.setText(userNumber);
        tv_email.setText(userEmail);
        tv_id.setText(userID);

    }
}
