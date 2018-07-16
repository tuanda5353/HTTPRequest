package com.example.ducmanh.httprequest;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class BackgroundTask_GET extends AsyncTask<String , Void , Void> {

    private String duongdan = MainActivity.SERVER_NAME;
    private TextView tvResult;
    private String strName,strScore;
    private String str;
    private ProgressDialog progressDialog;
    private Context context;



    public BackgroundTask_GET( Context context,TextView tvResult, String strName, String strScore) {
        this.context = context;
        this.tvResult = tvResult;
        this.strName = strName;
        this.strScore = strScore;
    }



    @Override
    protected Void doInBackground(String... voids) {
        duongdan += "?name=" + this.strName + "&score="+ this.strScore;
        try {
            URL url = new URL(duongdan);
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
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }



    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Sending.....");
        progressDialog.setIndeterminate(false);
        progressDialog.show();
    }



    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if (progressDialog.isShowing()){
            progressDialog.dismiss();
        }
        tvResult.setText(str);
    }
}
