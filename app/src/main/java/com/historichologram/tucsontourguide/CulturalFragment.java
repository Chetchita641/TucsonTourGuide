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

public class CulturalFragment extends Fragment {
    public CulturalFragment() {

    }

    private static final int NO_INFO_PROVIDED = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        //Set up the entrees... I mean, entries
        final ArrayList<LocationItem> locationItems = new ArrayList<>();

        locationItems.add(new LocationItem(R.string.desert_museum_name, R.string.desert_museum_short, R.string.desert_museum_long,
                R.string.desert_museum_tip, R.string.desert_museum_phone, R.string.desert_museum_geo,
                R.string.desert_museum_website, R.drawable.desert_museum));
        locationItems.add(new LocationItem(R.string.saguaro_monument_name, R.string.saguaro_monument_short, R.string.saguaro_monument_long,
                R.string.saguaro_monument_tip, NO_INFO_PROVIDED, NO_INFO_PROVIDED,
                R.string.saguaro_monument_website, R.drawable.saguaro_monument));
        locationItems.add(new LocationItem(R.string.reid_park_zoo_name, R.string.reid_park_zoo_short, R.string.reid_park_zoo_long,
                R.string.reid_park_zoo_tip, R.string.reid_park_zoo_phone, R.string.reid_park_zoo_geo,
                R.string.reid_park_zoo_website, R.drawable.reid_park_zoo));

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
