package com.example.attendance_management;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    ImageView imageView;//한국산업기술대 로고 이미지를 위한 변수

    private EditText et_id, et_pass;
    private Button btn_login, btn_register;

    @RequiresApi(api = Build.VERSION_CODES.M)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_xml);
        imageView=findViewById(R.id.kpu_logo); //한국산업기술대 로고 이미지뷰
        imageView.setImageResource(R.drawable.kpu_logo);

        et_id=findViewById(R.id.et_id);
        et_pass=findViewById(R.id.et_pass);

        btn_register=findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        btn_login = findViewById( R.id.btn_login );
        btn_login.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userID = et_id.getText().toString();
                String userPassword = et_pass.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject( response );
                            boolean success = jsonObject.getBoolean( "success" );

                            if(success) {//로그인 성공시

                                String userID = jsonObject.getString( "userID" );
                                String userPassword = jsonObject.getString( "userPassword" );
                                String userName = jsonObject.getString( "userName" );
                                String userNumber = jsonObject.getString( "userNumber" );
                                String userEmail = jsonObject.getString( "userEmail" );

                                Toast.makeText( getApplicationContext(), "로그인 성공", Toast.LENGTH_SHORT ).show();
                                Intent intent = new Intent( LoginActivity.this, HomeActivity.class );


                                intent.putExtra( "userID", userID );
                                intent.putExtra( "userPassword", userPassword );
                                intent.putExtra( "userName", userName );
                                intent.putExtra( "userNumber", userNumber );
                                intent.putExtra( "userEmail", userEmail );

                                startActivity( intent );
                            } else {//로그인 실패시
                                Toast.makeText( getApplicationContext(), "로그인 실패", Toast.LENGTH_SHORT ).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest( userID, userPassword, responseListener );
                RequestQueue queue = Volley.newRequestQueue( LoginActivity.this );
                queue.add( loginRequest );
            }
        });
        getPermissions();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void getPermissions() {
        String[] permissions = new String[]{Manifest.permission.INTERNET, Manifest.permission.CALL_PHONE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA};
        for(String s : permissions) {
            if (checkSelfPermission(s)
                    != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{s}, 1);
            }
        }
    }
}
