package com.example.ducmanh.httprequest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //    private Button btnGet, btnPost;
//    private TextView tvData;
    public static final String SERVER_NAME = "http://127.0.0.1:8888/phamducmanh_ph05169/student_GET.php";
    private EditText edtName, edtScore;
    private Button btnSend;
    private TextView tvResult;
    private String strName,strScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initviews();
    }



    private void initviews() {

        edtName = findViewById(R.id.edt_name);
        edtScore = findViewById(R.id.edt_score);
        btnSend = findViewById(R.id.btn_send);
        tvResult = findViewById(R.id.tv_result);
        btnSend.setOnClickListener(this);
//        btnGet = findViewById(R.id.btn_get);
//        btnPost = findViewById(R.id.btn_post);
//        tvData = findViewById(R.id.tvData);
//
//        btnGet.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                DataAsync dataAsync = new DataAsync(MainActivity.this,tvData);
//                dataAsync.execute();
//            }
//        });
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_send:
                strName = edtName.getText().toString();
                strScore = edtScore.getText().toString();
                BackgroundTask_GET backgroundTask_get= new BackgroundTask_GET(tvResult,strName,strScore,this);
                backgroundTask_get.execute();
                break;
        }

    }
}
