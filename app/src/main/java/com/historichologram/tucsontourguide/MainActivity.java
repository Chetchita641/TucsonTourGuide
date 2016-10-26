package com.historichologram.tucsontourguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView restaurants = (TextView) findViewById(R.id.restaurants_text_view);
        restaurants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToLocIntent(0);
            }
        });

        TextView cultural = (TextView) findViewById(R.id.cultural_text_view);
        cultural.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToLocIntent(1);
            }
        });

        TextView events = (TextView) findViewById(R.id.events_text_view);
        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToLocIntent(2);
            }
        });

        TextView nightlife = (TextView) findViewById(R.id.nightlife_text_view);
        nightlife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToLocIntent(3);
            }
        });
    }

    public void goToLocIntent(int position) {
        Intent intent = new Intent(MainActivity.this, LocationListActivity.class);
        //Not a hard coded string, but a variable name inside an intent
        intent.putExtra("position", position);
        startActivity(intent);
    }
}
