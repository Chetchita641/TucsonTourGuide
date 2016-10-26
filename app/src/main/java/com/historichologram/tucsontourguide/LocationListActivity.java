package com.historichologram.tucsontourguide;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by chrismacholtz on 10/2/16.
 */

public class LocationListActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set up the View Pager, adapter, and the TabLayout
        setContentView(R.layout.location_list_view_pager);
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);

        //Find out what category the user clicked on and go there first
        //Not a hard coded string, but a variable name inside an intent
        int position = getIntent().getIntExtra("position", 0);

        CategoryAdapter adapter = new CategoryAdapter(getApplicationContext(), getSupportFragmentManager() );
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.setCurrentItem(position);


    }
}
