package com.example.mbadr.technicaltask;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.health.PackageHealthStats;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import co.ceryle.segmentedbutton.SegmentedButtonGroup;

import org.w3c.dom.Text;

public class booking extends AppCompatActivity {

    private int passenger_coutn = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        // Used typefaces.
        Typeface relway_Bold = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Bold.ttf");
        Typeface relway_semiBold = Typeface.createFromAsset(getAssets(), "fonts/Raleway-SemiBold.ttf");
        Typeface relway_Regular = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Regular.ttf");

        //assigning typefaces to text
        TextView book_flight_text =(TextView) findViewById(R.id.book_Flight_text);
        book_flight_text.setTypeface(relway_Bold);

        TextView from_text = (TextView) findViewById(R.id.from_text);
        from_text.setTypeface(relway_Regular);

        TextView from_city_button = (TextView) findViewById(R.id.from_city_button);
        from_city_button.getBackground().setAlpha(0);
        from_city_button.setTypeface(relway_semiBold);

        TextView to_text = (TextView) findViewById(R.id.to_text);
        to_text.setTypeface(relway_Regular);

        TextView to_city_button = (TextView) findViewById(R.id.to_city_button);
        to_city_button.getBackground().setAlpha(0);
        to_city_button.setTypeface(relway_semiBold);

        TextView depart_text = (TextView) findViewById(R.id.depart_text);
        depart_text.setTypeface(relway_Regular);

        TextView depart_date_text = (TextView) findViewById(R.id.Depart_date_text);
        depart_date_text.setTypeface(relway_semiBold);

        TextView day_text= (TextView) findViewById(R.id.depart_day_text);
        day_text.setTypeface(relway_Regular);

        TextView return_text= (TextView) findViewById(R.id.return_text);
        return_text.setTypeface(relway_Regular);

        TextView return_date_text= (TextView) findViewById(R.id.Return_date_Text);
        return_date_text.setTypeface(relway_semiBold);

        TextView return_day_text= (TextView) findViewById(R.id.return_day_text);
        return_day_text.setTypeface(relway_Regular);

        TextView passenger_text = (TextView) findViewById(R.id.passenger_text);
        passenger_text.setTypeface(relway_Regular);

        TextView passenger_count_text = (TextView) findViewById(R.id.passenger_count);
        passenger_count_text.setTypeface(relway_semiBold);

        TextView economy_button= (TextView) findViewById(R.id.economy_button);
        economy_button.setTypeface(relway_Regular);

        TextView business_button= (TextView) findViewById(R.id.business_button);
        business_button.setTypeface(relway_Regular);

        TextView firstclass_button= (TextView) findViewById(R.id.firstclass_button);
        firstclass_button.setTypeface(relway_Regular);
    }

    //Buttons onClick actions
    public void onClick(View v)
    {
        Button b;
        switch (v.getId())
        {
            // Add passenger actions
            //just changing the text for now.
            case R.id.add_passenger_button:
                TextView t = (TextView) findViewById(R.id.passenger_count);
                passenger_coutn++;
                Log.d("count", passenger_coutn + "");
                t.setText(passenger_coutn + " Adults");
                break;

            // Economy button actions
            case R.id.economy_button:
                b = (Button) findViewById(R.id.business_button);
                //setting firstclass button background to match the desired design.
                b.setBackgroundResource(R.drawable.curved_background_colored_edge_15dp);
                //setting firstclass button text's color to match the desired design.
                b.setTextColor(getResources().getColor(R.color.babyBlue));

                b = (Button) findViewById(R.id.firstclass_button);
                //setting firstclass button background to match the desired design.
                b.setBackgroundResource(R.drawable.curved_background_colored_edge_15dp);
                //setting firstclass button text's color to match the desired design.
                b.setTextColor(getResources().getColor(R.color.babyBlue));

                b = (Button) findViewById(R.id.economy_button);
                //setting firstclass button background to match the desired design.
                b.setBackgroundResource(R.drawable.curved_background_15dp);
                //setting firstclass button text's color to match the desired design.
                b.setTextColor(getResources().getColor(R.color.white));
                break;
            // Business button actions
            //same way as economy button
            case R.id.business_button:
                b = (Button) findViewById(R.id.business_button);
                b.setBackgroundResource(R.drawable.curved_background_15dp);
                b.setTextColor(getResources().getColor(R.color.white));

                b = (Button) findViewById(R.id.firstclass_button);
                b.setBackgroundResource(R.drawable.curved_background_colored_edge_15dp);
                b.setTextColor(getResources().getColor(R.color.babyBlue));

                b = (Button) findViewById(R.id.economy_button);
                b.setBackgroundResource(R.drawable.curved_background_colored_edge_15dp);
                b.setTextColor(getResources().getColor(R.color.babyBlue));
                break;

            // Business button actions
            //same way as economy button
            case R.id.firstclass_button:
                b = (Button) findViewById(R.id.business_button);
                b.setBackgroundResource(R.drawable.curved_background_colored_edge_15dp);
                b.setTextColor(getResources().getColor(R.color.babyBlue));

                b = (Button) findViewById(R.id.firstclass_button);
                b.setBackgroundResource(R.drawable.curved_background_15dp);
                b.setTextColor(getResources().getColor(R.color.white));

                b = (Button) findViewById(R.id.economy_button);
                b.setBackgroundResource(R.drawable.curved_background_colored_edge_15dp);
                b.setTextColor(getResources().getColor(R.color.babyBlue));
                break;

            // Search button actions
            case R.id.search:
                Intent n = new Intent(this, Languages.class);
                startActivity(n);
        }
    }
}