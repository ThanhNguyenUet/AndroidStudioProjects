package com.example.basic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.basic.R;

import java.util.ArrayList;

public class GridViewCustomAdapter extends BaseAdapter {

    Context context;

    private ArrayList<String> countryNameList ;
    private ArrayList<Integer> imageList ;


    public GridViewCustomAdapter(Context context, ArrayList<String> countryNameList, ArrayList<Integer> imageList) {
        this.context = context;
        this.countryNameList = countryNameList;
        this.imageList = imageList;
    }

    @Override
    public int getCount() {
        return countryNameList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_view_gridview_customlistitem, viewGroup, false);
        }

        TextView country = view.findViewById(R.id.gridItemText);
        ImageView imageV = view.findViewById(R.id.gridItemImageView);

        country.setText(countryNameList.get(i));
        imageV.setImageResource(imageList.get(i));
        return view;
    }
}
