package com.example.basic.List_View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ScrollView;

import com.example.basic.R;

public class ScrollViewActivity extends AppCompatActivity {
    ScrollView scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_scrollview);
        // scrollView can only have 1 child -> put 1 layout with components inside ( 2 type HorizontalScrollView & ScrollView )
    }
}