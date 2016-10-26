package com.historichologram.tucsontourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


/**
 * Created by chrismacholtz on 10/2/16.
 */

public class CategoryAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case (0):
                return new RestaurantsFragment();
            case (1):
                return new CulturalFragment();
            case (2):
                return new EventsFragment();
            case (3):
                return new NightlifeFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //If I could use the String Ids here, I'd be happy to. However, I'm not entirely sure to how to get them in this override
        switch (position) {
            case (0):
                return "Restuarants";
            case (1):
                return "Cultural Attractions";
            case (2):
                return "Events";
            case (3):
                return "Nightlife";
            default:
                return null;
        }
    }
}
