package com.example.mbadr.technicaltask;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.constraint.solver.SolverVariable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Used typeFaces.
        //although I knew that I should create global typeface class to access the typefaces in all other classes, but i forgot.

        Typeface relway_semiBold = Typeface.createFromAsset(getAssets(), "fonts/Raleway-SemiBold.ttf");
        Typeface relway_regular = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Regular.ttf");


        //assigning typefaces to text
        TextView sign_in_text = (TextView) findViewById(R.id.Sing_in_text);
        sign_in_text.setTypeface(relway_semiBold);

        TextView username_text = (TextView) findViewById(R.id.username_text);
        username_text.setTypeface(relway_regular);

        TextView password_text = (TextView) findViewById(R.id.password_text);
        password_text.setTypeface(relway_regular);

        Button sign_in_button = (Button) findViewById(R.id.sign_in_button);
        sign_in_button.setTypeface(relway_regular);

        Button forget_password_buton = (Button) findViewById(R.id.forget_password_button);
        forget_password_buton.getBackground().setAlpha(0);
        forget_password_buton.setTypeface(relway_regular);

        Button facebook_login_button = (Button) findViewById(R.id.login_facebook_button);
        facebook_login_button.setTypeface(relway_regular);

        Button sign_up_button = (Button) findViewById(R.id.sign_up_button);
        sign_up_button.getBackground().setAlpha(20);
        sign_up_button.setTypeface(relway_regular);
    }

    //Button onClick actions
    public void onclick(View v)
    {
        EditText username = (EditText) findViewById(R.id.username_input_field);
        EditText password = (EditText) findViewById(R.id.password_input_field);
        String s; // String that holds username.
        String p; // String that holds password.
        switch (v.getId())
        {
            //sign in button Action.
            case R.id.sign_in_button:
                s = username.getText().toString();
                p = password.getText().toString();
                if(s.length()!= 0 && p.length() != 0)
                {
                    Log.d("USERNAME",s);
                    Log.d("PASSWORD",p);
                    Intent n = new Intent(this, booking.class);
                    startActivity(n);
                }
                break;
            //other actions to be added
        }
    }
}
