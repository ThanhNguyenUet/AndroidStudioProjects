package com.example.basic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.basic.List_View.ConstraintActivity;
import com.example.basic.List_View.GridViewActivity;
import com.example.basic.List_View.ListViewActivity;
import com.example.basic.List_View.RecyclerViewActivity;
import com.example.basic.List_View.ScrollViewActivity;
import com.example.basic.List_View.WebViewActivity;

public class ListAndView extends AppCompatActivity {

    Button constraint;

    Button listview;

    Button recyclerview;

    Button gridview;

    Button scrollview;

    Button webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_and_view);

        constraint = findViewById(R.id.constraint);
        listview = findViewById(R.id.listview);
        recyclerview = findViewById(R.id.recyclerview);
        gridview = findViewById(R.id.gridview);
        scrollview = findViewById(R.id.scrollview);
        webview = findViewById(R.id.webview);
        constraint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent constraintIntent = new Intent(getApplicationContext(), ConstraintActivity.class);
                startActivity(constraintIntent);
            }
        });
        listview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listviewIntent = new Intent(getApplicationContext(), ListViewActivity.class);
                startActivity(listviewIntent);
            }
        });
        recyclerview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent recyclerViewIntent = new Intent(getApplicationContext(), RecyclerViewActivity.class);
                startActivity(recyclerViewIntent);
            }
        });
        gridview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gridViewIntent = new Intent(getApplicationContext(), GridViewActivity.class);
                startActivity(gridViewIntent);
            }
        });
        scrollview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent scrollViewIntent = new Intent(getApplicationContext(), ScrollViewActivity.class);
                startActivity(scrollViewIntent);
            }
        });
        webview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent webViewIntent = new Intent(getApplicationContext(), WebViewActivity.class);
                startActivity(webViewIntent);
            }
        });
    }
}