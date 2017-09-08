package com.example.mbadr.technicaltask;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Languages extends AppCompatActivity {

    private static String url = "https://www.memphistours.com/ws/languages/all_languages/ ";

    private String TAG = Languages.class.getSimpleName();

    private ProgressDialog pDialog;
    private ListView lv;

    ArrayList<HashMap<String,String>> languagesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_languages);

        languagesList =  new ArrayList<>();

        lv = (ListView) findViewById(R.id.respons);
        new GetLanguages().execute();
    }

    private class GetLanguages extends AsyncTask<Void,Void,Void>
    {
        protected void onPreExecute()
        {
            super.onPreExecute();
            pDialog = new ProgressDialog(Languages.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            return null;
        }
    }


}


