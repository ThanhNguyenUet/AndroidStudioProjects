package com.example.basic.List_View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.basic.Adapter.RecyclerViewCustomAdapter;
import com.example.basic.R;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewCustomAdapter recyclerViewCustomAdapter;

    private ArrayList<String> countryNameList = new ArrayList<>();
    private ArrayList<String> detailsList = new ArrayList<>();
    private ArrayList<Integer> imageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_recyclerview);

        recyclerView = findViewById(R.id.recyclerView);
        // set the layout for the recyclerview -> LinearLayout = item tu tren xuong
        // gridview populates data vertically in a single column -> recyclerview can populate both ways & as many columns as well so we have to decide
        // the vertically in the view is just a default.
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        // populate data
        countryNameList.add("United Kingdom");
        countryNameList.add("Germany");
        countryNameList.add("United States");

        detailsList.add("This is the United Kingdom");
        detailsList.add("This is the Germany");
        detailsList.add("This is the United States");

        imageList.add(R.drawable.ic_launcher_foreground);
        imageList.add(R.drawable.ic_launcher_foreground);
        imageList.add(R.drawable.ic_launcher_foreground);

        //setAdapter
        recyclerViewCustomAdapter = new RecyclerViewCustomAdapter(countryNameList, detailsList, imageList, this);
        recyclerView.setAdapter(recyclerViewCustomAdapter);


    }
}