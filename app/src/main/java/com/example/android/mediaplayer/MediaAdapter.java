package com.example.android.mediaplayer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MediaAdapter extends ArrayAdapter<Media>{

    public MediaAdapter(Activity context, ArrayList<Media> media){
        super(context, 0, media);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Media currentMedia = getItem(position);

        TextView mediaTextView = (TextView)listItemView.findViewById(R.id.media_text_view);
        mediaTextView.setText(currentMedia.getMediaTitle());

        return listItemView;
    }
}
