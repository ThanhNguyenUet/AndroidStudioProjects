package com.example.basic.List_View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.basic.Adapter.ListViewCustomAdapter;
import com.example.basic.R;

import java.lang.reflect.Array;

public class ListViewActivity extends AppCompatActivity {
    ListView listView;
    String countries[];

    ArrayAdapter<String> adapter;
    ListViewCustomAdapter listViewCustomAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_listviewlayout);

        listView = findViewById(R.id.listview);
        //countries = getResources().getStringArray(R.array.countries);
        // This is for default string adapter which will
/*


        // ArrayAdapter (context = where this adapter will work, layout of single item of listview, string array)
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        listView.setAdapter(adapter);
        // i = position , adapterview = parent, l = id of an item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String country = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), country, Toast.LENGTH_SHORT).show();
            }
        });
*/
        listViewCustomAdapter = new ListViewCustomAdapter(this);
        listView.setAdapter(listViewCustomAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String country = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), country, Toast.LENGTH_SHORT).show();
            }
        });
    }
}