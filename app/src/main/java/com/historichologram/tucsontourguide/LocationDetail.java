package com.historichologram.tucsontourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by chrismacholtz on 10/4/16.
 */

public class LocationDetail extends AppCompatActivity {

    private static final int NO_INFO_PROVIDED = -1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_detail);

        //These are not hard coded strings, but variable names from the intent
        TextView locationDetailName = (TextView) findViewById(R.id.location_detail_name);
        locationDetailName.setText(getIntent().getIntExtra("name", NO_INFO_PROVIDED));

        TextView locationDetailShort = (TextView) findViewById(R.id.location_detail_short);
        locationDetailShort.setText(getIntent().getIntExtra("short", NO_INFO_PROVIDED));

        TextView locationDetailLong = (TextView) findViewById(R.id.location_detail_long);
        locationDetailLong.setText(getIntent().getIntExtra("long", NO_INFO_PROVIDED));

        TextView locationDetailTip = (TextView) findViewById(R.id.location_detail_tip);
        locationDetailTip.setText(getIntent().getIntExtra("tip", NO_INFO_PROVIDED));

        //Check to see if there is an image
        ImageView locationDetailImage = (ImageView) findViewById(R.id.location_detail_image);
        if (getIntent().getIntExtra("image", NO_INFO_PROVIDED) != NO_INFO_PROVIDED)
            locationDetailImage.setImageResource(getIntent().getIntExtra("image", NO_INFO_PROVIDED));
        else
            locationDetailImage.setVisibility(View.GONE);

        //Check to see if there are places for the buttons, and then do what they're supposed to do. If not, a toast
        //Call
        LinearLayout callButton = (LinearLayout) findViewById(R.id.location_detail_call);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getIntent().getIntExtra("call", NO_INFO_PROVIDED) != NO_INFO_PROVIDED) {
                    final String phoneNumber = getString(getIntent().getIntExtra("call", NO_INFO_PROVIDED));
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + phoneNumber));
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "No Phone Number Available", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Directions
        LinearLayout directionsButton = (LinearLayout) findViewById(R.id.location_detail_directions);
        directionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getIntent().getIntExtra("directions", NO_INFO_PROVIDED) != NO_INFO_PROVIDED) {
                    final String geoLocation = getString(getIntent().getIntExtra("directions", NO_INFO_PROVIDED));
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("geo:" + geoLocation));
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "No Location Available", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Website
        LinearLayout websiteButton = (LinearLayout) findViewById(R.id.location_detail_website);
        websiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getIntent().getIntExtra("website", NO_INFO_PROVIDED) != NO_INFO_PROVIDED) {
                    final String website = getString(getIntent().getIntExtra("website", NO_INFO_PROVIDED));
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http:" + website));
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "No website available", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}