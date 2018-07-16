package com.example.ducmanh.httprequest;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class DataAsync extends AsyncTask<String,Void,Void> {
    private String str;
    private TextView tvData;
    private Context context;



    public DataAsync( Context context,TextView tvData) {
        this.context = context;
        this.tvData = tvData;
    }



    @Override
    protected Void doInBackground(String... strings) {
        getData();
        return null;
    }

    public void getData(){
        String link = "https://reqres.in/api/users?page=2" ;
        try {
            URL url = new URL(link);
            HttpsURLConnection urlConnection = (HttpsURLConnection)url.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream())
            );
            String line = "";
            StringBuffer sb = new StringBuffer("");
            while ((line = in.readLine())!=null){
                sb.append(line);
            }
            str =sb.toString();
            urlConnection.disconnect();
            Log.d("dulieu", sb+"getData: ");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        tvData.setText(str);
    }
}
