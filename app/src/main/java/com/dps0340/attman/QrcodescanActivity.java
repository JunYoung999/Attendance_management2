package com.dps0340.attman;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.appcompat.app.AppCompatActivity;

public class QrcodescanActivity extends AppCompatActivity {

    private EditText edt;
    private TextView edt2;
    private ImageView image_check;
    int count=0;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qrscan_xml);
        edt=findViewById(R.id.edt_attendancecheck);
        edt2=findViewById(R.id.edt2);
        image_check=findViewById(R.id.image_check);

        new IntentIntegrator(this).initiateScan();
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
                edt.setText("QR코드를 다시 스캔하여 주세요!");
                edt.setTextColor(Color.RED);
                image_check.setVisibility(View.INVISIBLE);
                edt2.setVisibility(View.GONE);

                // todo
            } else {
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                // todo
                edt.setText(result.getContents()+" 출석이 완료되었습니다!");
                edt2.setVisibility(View.INVISIBLE);
                edt2.setText(result.getContents());
                String attendanceInformation = result.getContents();
                long now=System.currentTimeMillis();
                Date mDate = new Date(now);
                SimpleDateFormat simpleData = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String time=simpleData.format(mDate);


                        Response.Listener<String> responseListener = new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                try {
                                    JSONObject jsonObject = new JSONObject( response );
                                    boolean success = jsonObject.getBoolean( "success" );
                                    //출석 성공시
                                    if(success) {
                                        //String time = jsonObject.getString("time");
                                        //String attendanceInformation2 = jsonObject.getString("attendanceInformation");
                                        String attendanceInformation = edt2.getText().toString();
                                        long now=System.currentTimeMillis();
                                        Date mDate = new Date(now);
                                        SimpleDateFormat simpleData = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                                        String time=simpleData.format(mDate);
                                        Intent intent2 = getIntent();
                                        String userName = intent2.getStringExtra("userName");
                                        String userNumber = intent2.getStringExtra("userNumber");
                                        String userEmail = intent2.getStringExtra("userEmail");
                                        String userID = intent2.getStringExtra("userID");
                                        Toast.makeText( getApplicationContext(), " 출석정보 저장성공", Toast.LENGTH_SHORT ).show();
                                        Intent intent = new Intent(QrcodescanActivity.this,AttendancestatusActivity.class);
                                        count++;
                                        intent.putExtra("userName",userName);
                                        intent.putExtra("userNumber",userNumber);
                                        intent.putExtra( "userID", userID );
                                        intent.putExtra( "userEmail", userEmail );
                                        intent.putExtra("attendanceInformation",attendanceInformation);
                                        intent.putExtra("time",time);
                                        intent.putExtra("count",count);
                                        startActivity(intent);


                                        //출석 실패시
                                    } else {
                                        Toast.makeText( getApplicationContext(), "출석정보 저장실패", Toast.LENGTH_SHORT ).show();
                                        return;
                                    }

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        };

                        //서버로 Volley를 이용해서 요청
                        AttendanceRequest attendanceRequest = new AttendanceRequest(attendanceInformation,time,responseListener);
                        RequestQueue queue = Volley.newRequestQueue(QrcodescanActivity.this);
                        queue.add(attendanceRequest);


            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}
