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

public class NightlifeFragment extends Fragment {
    public NightlifeFragment() {

    }

    private static final int NO_INFO_PROVIDED = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        //Set up the entrees... I mean, entries
        final ArrayList<LocationItem> locationItems = new ArrayList<>();

        locationItems.add(new LocationItem(R.string.club_congress_name, R.string.club_congress_short, R.string.club_congress_long,
                R.string.club_congress_tip, R.string.club_congress_phone, R.string.club_congress_geo,
                R.string.club_congress_website, R.drawable.club_congress));
        locationItems.add(new LocationItem(R.string.loft_cinema_name, R.string.loft_cinema_short, R.string.loft_cinema_long,
                R.string.loft_cinema_tip, R.string.loft_cinema_phone, R.string.loft_cinema_geo,
                R.string.loft_cinema_website, R.drawable.loft_cinema));
        locationItems.add(new LocationItem(R.string.rialto_name, R.string.rialto_short, R.string.rialto_long,
                R.string.rialto_tip, R.string.rialto_phone, R.string.rialto_geo,
                R.string.rialto_website, R.drawable.rialto));

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
