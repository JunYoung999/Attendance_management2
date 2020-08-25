package com.example.attendance_management;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    ImageView imageView; //한국산업기술대 로고를 위한 이미지 변수
    private EditText et_id, et_pass, et_name, et_number, et_email; //아이디,패스워드,나이,학번,이메일 변수
    private Button btm_register; //회원가입 버튼 변수

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_xml);
        imageView=findViewById(R.id.kpu_logo); //한국산업기술대 로고 이미지 뷰
        imageView.setImageResource(R.drawable.kpu_logo);

        //아이디값 찾아주기
        et_id=findViewById(R.id.et_id2);
        et_pass=findViewById(R.id.et_pass2);
        et_name=findViewById(R.id.et_name2);
        et_number=findViewById(R.id.et_number2);
        et_email=findViewById(R.id.et_email2);

        //회원가입 버튼 클릭 시 수행
        btm_register=findViewById(R.id.btn_register2);
        btm_register.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String userID=et_id.getText().toString();
                String userPass=et_pass.getText().toString();
                String userName=et_name.getText().toString();
                int userNumber=Integer.parseInt(et_number.getText().toString());
                String userEmail=et_email.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject( response );
                            boolean success = jsonObject.getBoolean( "success" );

                            //회원가입 성공시
                            if(success) {
                                Toast.makeText( getApplicationContext(), "성공", Toast.LENGTH_SHORT ).show();

                                Intent intent = new Intent( RegisterActivity.this, LoginActivity.class );
                                startActivity( intent );

                                //회원가입 실패시
                            } else {
                                Toast.makeText( getApplicationContext(), "실패", Toast.LENGTH_SHORT ).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                //서버로 Volley를 이용해서 요청
                RegisterRequest registerRequest = new RegisterRequest( userID, userPass, userName, userNumber,userEmail,responseListener);
                RequestQueue queue = Volley.newRequestQueue( RegisterActivity.this );
                queue.add( registerRequest );
            }
        });
    }
}
