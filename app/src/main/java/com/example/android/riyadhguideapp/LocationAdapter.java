
package com.example.android.riyadhguideapp;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class LocationAdapter extends ArrayAdapter<Location>  {

    private int mColorResourceId;
    private String mListType ;

    public LocationAdapter(Context context, ArrayList<Location> words, int colorResourceId , String listType) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
        mListType = listType ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            if (mListType == "malls" ) {
                listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.malls_list, parent, false);
            }
            else
            {
                if (mListType == "events" ) {
                    listItemView = LayoutInflater.from(getContext()).inflate(
                            R.layout.events_list, parent, false);
                }
                else
                {
                    if (mListType == "parks" || mListType == "libraries") {
                        listItemView = LayoutInflater.from(getContext()).inflate(
                                R.layout.parks_and_libraries_list, parent, false);
                    }
                }
            }

        }

        Location currentLocation= getItem(position);

        TextView location = (TextView) listItemView.findViewById(R.id.location_name);
        location.setText(currentLocation.getLocationName());

        if (mListType == "malls" || mListType == "events") {
            TextView details = (TextView) listItemView.findViewById(R.id.details);
            details.setText(currentLocation.getmLocationAddress());
        }

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        imageView.setImageResource(currentLocation.getmLocationImage());

        View textContainer = listItemView.findViewById(R.id.text_container);

        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}