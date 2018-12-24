package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.provider.UserDictionary;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {
private int mColorId;
    public WordAdapter(Activity context, @NonNull ArrayList<Word> objects, int colorId) {
        //resource value is 0 because we need to make our custom listview
        // not using the view provided by arrayAdapter class
        super(context, 0, objects);
        mColorId=colorId;
    }

    @Override
    public View getView(int position, @Nullable View convertView, ViewGroup parent) {

        View listItemView=convertView;
        //At first we have to create the listview so in starting the listview will be null
        if(listItemView==null)
        {
        listItemView=LayoutInflater.from(getContext()).inflate(R.layout.list_view,parent,false);
        }
        //by this we have created our listview now use this view to sert all textviews and image view
        // now first find out the current position of the view
        Word currentWord=getItem(position);
        //this will give us the default or english word
        TextView DefaultTextView=(TextView)listItemView.findViewById(R.id.defaultTextView);
        DefaultTextView.setText(currentWord.getDefaultTransition());

        //now the set the next text view with the miwok word

        TextView MiwokTextView=(TextView)listItemView.findViewById(R.id.MiwokView);
        MiwokTextView.setText(currentWord.getMiwokTransition());

        ImageView imageView=(ImageView)listItemView.findViewById(R.id.Image_item_icon);
        if(currentWord.hasImage()) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(currentWord.getImageResourceId());
        }
        else {
           imageView.setVisibility(View.GONE);
        }
        View TextContainer=listItemView.findViewById(R.id.container);
        int color=ContextCompat.getColor(getContext(),mColorId);


        TextContainer.setBackgroundColor(color);

        View imageBackground=listItemView.findViewById(R.id.imageButton);
        imageBackground.setBackgroundColor(color);


        return listItemView;
    }
}
