package com.example.basic.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.basic.R;

public class ListViewCustomAdapter extends BaseAdapter {
    Context context;
    LayoutInflater layoutInflater;
    String[] countries;

    Integer[] countries_images;

    public ListViewCustomAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.countries = context.getResources().getStringArray(R.array.countries);
        this.countries_images = new Integer[]{
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground
        };
    }

    // should be defined otherwise getcount = 0 -> not populate the data at all
    @Override
    public int getCount() {
        return countries.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    // i = position , view = convertView , viewgroup =
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = layoutInflater.inflate(R.layout.list_view_listviewlayout_customlistitem, null);
        }
        TextView country = view.findViewById(R.id.country);
        ImageView country_image = view.findViewById(R.id.sampleImage);

        country.setText(countries[i]);

        country_image.setImageResource(countries_images[i]);

        return view;
    }
}
