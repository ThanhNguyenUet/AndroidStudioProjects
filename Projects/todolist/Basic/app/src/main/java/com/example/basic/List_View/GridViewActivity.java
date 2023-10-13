package com.example.basic.List_View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.basic.Adapter.GridViewCustomAdapter;
import com.example.basic.R;

import java.util.ArrayList;

public class GridViewActivity extends AppCompatActivity {

    private GridView gridView ;
    private ArrayList<String> countryNameList = new ArrayList<>();

    private ArrayList<Integer> imageList = new ArrayList<>();

    private GridViewCustomAdapter gridViewCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_gridview);

        gridView = findViewById(R.id.gridView);
        fillArray();

        gridViewCustomAdapter = new GridViewCustomAdapter(this, countryNameList, imageList);
        gridView.setAdapter(gridViewCustomAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(GridViewActivity.this, "You selected" + countryNameList.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void fillArray() {
        countryNameList.add("United Kingdom");
        countryNameList.add("Germany");
        countryNameList.add("United States");
        countryNameList.add("United Kingdom");
        countryNameList.add("Germany");
        countryNameList.add("United States");
        countryNameList.add("United Kingdom");
        countryNameList.add("Germany");
        countryNameList.add("United States");

        imageList.add(R.drawable.ic_launcher_foreground);
        imageList.add(R.drawable.ic_launcher_foreground);
        imageList.add(R.drawable.ic_launcher_foreground);
        imageList.add(R.drawable.ic_launcher_foreground);
        imageList.add(R.drawable.ic_launcher_foreground);
        imageList.add(R.drawable.ic_launcher_foreground);
        imageList.add(R.drawable.ic_launcher_foreground);
        imageList.add(R.drawable.ic_launcher_foreground);
        imageList.add(R.drawable.ic_launcher_foreground);
    }
}