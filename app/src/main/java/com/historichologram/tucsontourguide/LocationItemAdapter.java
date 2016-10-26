package com.historichologram.tucsontourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.view.View.GONE;

/**
 * Created by chrismacholtz on 10/2/16.
 */

public class LocationItemAdapter extends ArrayAdapter<LocationItem> {

    //private int mCategoryColor;
    public LocationItemAdapter(Context context, ArrayList<LocationItem> locationItems) {
        super(context, 0, locationItems);
        //mCategoryColor = categoryColor;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.location_list_item, parent, false);
        }

        LocationItem currentLocation = getItem(position);

        //Get the values and set them
        TextView currentLocationNameId = (TextView) listItemView.findViewById(R.id.location_item_name_text_view);
        currentLocationNameId.setText(currentLocation.getLocationNameId());

        TextView currentLocationShortId = (TextView) listItemView.findViewById(R.id.location_item_short_text_view);
        currentLocationShortId.setText(currentLocation.getLocationShortDescriptionId());

        ImageView currentLocationImageId = (ImageView) listItemView.findViewById(R.id.location_item_image);
        if (currentLocation.hasImage()) {
           currentLocationImageId.setImageResource(currentLocation.getLocationImageId());
           currentLocationImageId.setVisibility(View.VISIBLE);
        } else {
            currentLocationImageId.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);

        // Find the color that the resource ID maps to
//        int color = ContextCompat.getColor(getContext(), mCategoryColor);
//        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
