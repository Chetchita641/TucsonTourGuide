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

public class EventsFragment extends Fragment {
    public EventsFragment() {

    }

    private static final int NO_INFO_PROVIDED = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        //Set up the entrees... I mean, entries
        final ArrayList<LocationItem> locationItems = new ArrayList<>();

        locationItems.add(new LocationItem(R.string.tucson_meet_yourself_name, R.string.tucson_meet_yourself_short, R.string.tucson_meet_yourself_long,
                R.string.tucson_meet_yourself_tip, R.string.tucson_meet_yourself_phone, R.string.tucson_meet_yourself_geo,
                R.string.tucson_meet_yourself_website, R.drawable.tucson_meet_yourself));
        locationItems.add(new LocationItem(R.string.nam_jam_name, R.string.nam_jam_short, R.string.nam_jam_long,
                R.string.nam_jam_tip, NO_INFO_PROVIDED, R.string.nam_jam_geo,
                R.string.nam_jam_website, R.drawable.nam_jam));
        locationItems.add(new LocationItem(R.string.festival_of_books_name, R.string.festival_of_books_short, R.string.festival_of_books_long,
                R.string.festival_of_books_tip, NO_INFO_PROVIDED, R.string.festival_of_books_geo,
                R.string.festival_of_books_website, R.drawable.festival_of_books));

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
