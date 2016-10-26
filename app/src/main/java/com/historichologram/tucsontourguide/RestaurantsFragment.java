package com.historichologram.tucsontourguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by chrismacholtz on 10/2/16.
 */

public class RestaurantsFragment extends Fragment {
    public RestaurantsFragment() {

    }

    private static final int NO_INFO_PROVIDED = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        //Set up the entrees... I mean, entries
        final ArrayList<LocationItem> locationItems = new ArrayList<>();

        locationItems.add(new LocationItem(R.string.beyond_bread_name, R.string.beyond_bread_short, R.string.beyond_bread_long,
                R.string.beyond_bread_tip, R.string.beyond_bread_phone, R.string.beyond_bread_geo,
                R.string.beyond_bread_website, R.drawable.beyond_bread));
        locationItems.add(new LocationItem(R.string.red_garter_name, R.string.red_garter_short, R.string.red_garter_long,
                R.string.red_garter_tip, R.string.red_garter_phone, R.string.red_garter_geo,
                R.string.red_garter_website, R.drawable.red_garter));
        locationItems.add(new LocationItem(R.string.taco_shop_name, R.string.taco_shop_short, R.string.taco_shop_long,
                R.string.taco_shop_tip, R.string.taco_shop_phone, R.string.taco_shop_geo,
                NO_INFO_PROVIDED, R.drawable.taco_shop));

        //Set the adapter and put it into the List View
        LocationItemAdapter adapter = new LocationItemAdapter(getActivity(), locationItems);
        ListView listView = (ListView) rootView.findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        //Set an OnItemClickListener and pass on the intent
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                LocationItem clickedItem = locationItems.get(position);
                Intent intent = new Intent(getActivity(), LocationDetail.class);

                //Pass along the arrayed information
                //Also, these are not hardcoded strings, but variable names (as far as I'm aware)
                intent.putExtra("name", clickedItem.getLocationNameId());
                intent.putExtra("short", clickedItem.getLocationShortDescriptionId());
                intent.putExtra("long", clickedItem.getLocationLongId());
                intent.putExtra("tip", clickedItem.getLocationTipId());

                //If there's more information...
                if (clickedItem.hasImage())
                    intent.putExtra("image", clickedItem.getLocationImageId());
                else
                    intent.putExtra("image", NO_INFO_PROVIDED);

                if (clickedItem.hasButtons()) {
                    intent.putExtra("call", clickedItem.getLocationCallId());
                    intent.putExtra("directions", clickedItem.getLocationDirectionsId());
                    intent.putExtra("website", clickedItem.getLocationWebsiteId());
                } else {
                    intent.putExtra("call", NO_INFO_PROVIDED);
                    intent.putExtra("directions", NO_INFO_PROVIDED);
                    intent.putExtra("website", NO_INFO_PROVIDED);
                }

                //Let's start up this bad boy
                startActivity(intent);
            }
        });

        return rootView;
    }
}
