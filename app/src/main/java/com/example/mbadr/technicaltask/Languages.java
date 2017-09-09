package com.example.mbadr.technicaltask;

import android.app.ProgressDialog;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

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

        Typeface relway_semiBold = Typeface.createFromAsset(getAssets(), "fonts/Raleway-SemiBold.ttf");
        TextView title_bar = (TextView) findViewById(R.id.title_bar);
        title_bar.setTypeface(relway_semiBold);

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
            HttpHandler sh = new HttpHandler();
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, jsonStr);

            if(jsonStr != null)
            {
                try {
                    JSONArray response = new JSONArray(jsonStr);

                    for(int i =0; i < response.length();i++)
                    {
                        JSONObject currentLanguage = response.getJSONObject(i);

                        String abbrev = currentLanguage.getString("abbrev");
                        String  title = currentLanguage.getString("title");

                        HashMap<String, String> language = new HashMap<>();
                        language.put("title",title);
                        language.put("abbrev",abbrev);


                        languagesList.add(language);
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),"Json parsing error: " + e.getMessage(),Toast.LENGTH_LONG
                            ).show();
                        }
                    });
                }
            }
            else
            {
                Log.e(TAG, "couldn't get json from server.");

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),"couldn't get json from server.",Toast.LENGTH_LONG
                        ).show();
                    }
                });

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            if(pDialog.isShowing())
                pDialog.dismiss();
            LanguageListAdapter adapter = new LanguageListAdapter(languagesList,Languages.this);

            lv.setAdapter(adapter);
        }
    }


}



