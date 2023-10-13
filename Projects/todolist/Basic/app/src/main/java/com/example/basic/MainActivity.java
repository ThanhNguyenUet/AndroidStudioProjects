package com.example.basic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.basic.LifeCycle.FragmentLifeCycle;

public class MainActivity extends AppCompatActivity {

    Button interaction;

    Button list_and_view;

    Button life_cycle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        interaction = findViewById(R.id.interaction);
        list_and_view = findViewById(R.id.listandview);
        life_cycle = findViewById(R.id.life_cycle_button);
        interaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent interact = new Intent(getApplicationContext(), UserInteraction.class);
                startActivity(interact);
            }
        });
        list_and_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent interact = new Intent(getApplicationContext(), ListAndView.class);
                startActivity(interact);
            }
        });
        life_cycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent licycle = new Intent(getApplicationContext(), FragmentLifeCycle.class);
                startActivity(licycle);
            }
        });

    }
}