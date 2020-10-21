package com.dps0340.attman;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SelfdiagnosisActivity extends AppCompatActivity {
    private ArrayList<Pair<String, String>> symptomsList;

    private ArrayList<Integer> flags;
    int call_number;
    private TextView tv_name;
    static final int REQUEST_IMAGE_CAPTURE = 1;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.selfdiagnosis_xml);

        tv_name=findViewById(R.id.tv_name5);
        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        tv_name.setText(userName);

        constructSymptomsList();
        constructFlags();
        inflateSymptomsLayout();
    }

    private void constructSymptomsList() {
        String[] englishSymptoms = new String[]{"Cough", "Fever", "Throat discomfort", "Headache", "Nasal congestion"};
        String[] koreanSymptoms = new String[]{"기침", "37.5도 이상 열 또는 발열감", "인후통", "두통", "코막힘"};

        symptomsList = new ArrayList<Pair<String, String>>();

        for(int i=0;i<englishSymptoms.length;i++) {
            String constructed = String.format("%s(%s)", koreanSymptoms[i], englishSymptoms[i]);
            symptomsList.add(new Pair<String, String>(englishSymptoms[i], constructed));
        }
    }

    private void inflateSymptomsLayout() {
        int size = symptomsList.size();
        LayoutInflater inflater = getLayoutInflater();
        ViewGroup root = findViewById(R.id.SymptomsLayout);

        for(int i=0; i < size; i++) {
            inflater.inflate(R.layout.form_xml, root);
            View currentView = root.getChildAt(root.getChildCount()-1);
            TextView textView = currentView.findViewById(R.id.symptom_textView);
            textView.setText(symptomsList.get(i).second);
            Button noButton = currentView.findViewById(R.id.no_button);
            Button yesButton = currentView.findViewById(R.id.yes_button);
            noButton.setOnClickListener(ListenerFactory.clickListenerFactory(this, i, 2, Color.GREEN));
            yesButton.setOnClickListener(ListenerFactory.clickListenerFactory(this, i, 1, Color.RED));
        }
    }

    public void setSymptomsFlag(int idx, int flag) {
        if(flags.size() <= idx) {
            return;
        }
        flags.set(idx, flag);
    }
    public void constructFlags() {
        flags = new ArrayList<Integer>();
        for(int i=0; i<symptomsList.size(); i++) {
            flags.add(0);
        }
    }
    private void dispatchTakePictureIntent(Intent callback) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            // asynchronous, non-blocking 상태
            // 수정 TODO
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            startActivity(callback);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(getApplicationContext(), "ActivityNotFoundException!!", Toast.LENGTH_SHORT);
            // display error state to the user
        }
    }

    public void call() {
        for(int i=0; i<flags.size(); i++) {
            if(flags.get(i) != 2) {
                return;
            }
        }
        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        String userNumber = intent.getStringExtra("userNumber");
        String userEmail = intent.getStringExtra("userEmail");
        String userID = intent.getStringExtra("userID");
        intent = new Intent(getBaseContext(), ResultActivity.class);
        call_number++;
        for(int i=0; i < symptomsList.size(); i++) {
            Pair<String, String> p = symptomsList.get(i);
            String name = p.first;
            int flag = flags.get(i);
            intent.putExtra(name, flag);
        }
        intent.putExtra("userName",userName);
        intent.putExtra("userNumber",userNumber);
        intent.putExtra( "userID", userID );
        intent.putExtra( "userEmail", userEmail );
        intent.putExtra("call_number",call_number);

        dispatchTakePictureIntent(intent);
    }
}
