package com.example.attendance_management;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

public class RegisterRequest extends StringRequest {
    final static private String URL = "http://an950120.dothome.co.kr/Register.php";
    private Map<String,String>map;

    public RegisterRequest(String userID, String userPassword, String userName, int userNumber, String userEmail,Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userID", userID);
        map.put("userPassword", userPassword);
        map.put("userName", userName);
        map.put("userNumber", userNumber+" ");
        map.put("userEmail",userEmail);
    }

    @Override
    protected Map<String, String>getParams() throws AuthFailureError {
        return map;
    }
}
