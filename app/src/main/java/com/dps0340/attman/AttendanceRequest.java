package com.dps0340.attman;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class AttendanceRequest extends StringRequest {

    //서버 URL 설정(php 파일 연동)
    final static private String URL = "http://an950120.dothome.co.kr/Attendance2.php";
    private final Map<String,String> map;
    //private Map<String, String>parameters;

    public AttendanceRequest(String attendanceInformation,String time, Response .Listener<String>listener){
        super(Method.POST,URL,listener,null);

        map=new HashMap<>();
        map.put("attendanceInformation",attendanceInformation);
        map.put("time",time);
    }

    @Override
    protected Map<String,String>getParams() throws AuthFailureError{
        return map;
    }
}
