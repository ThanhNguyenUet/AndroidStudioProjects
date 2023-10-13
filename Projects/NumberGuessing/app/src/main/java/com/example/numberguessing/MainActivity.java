package com.example.numberguessing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView textView;
    private RadioButton two_digit, three_digit, four_digit;
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolBar);
        setActionBar(toolbar);

        btn = findViewById(R.id.btn_choose);
        two_digit = findViewById(R.id.two_digit);
        three_digit = findViewById(R.id.three_digit);
        four_digit = findViewById(R.id.four_digit);
        textView = findViewById(R.id.textView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GameActivity.class);

                if (!two_digit.isChecked() && !three_digit.isChecked() && !four_digit.isChecked()) {
                    Snackbar.make(view, "Please select a number of digits", Snackbar.LENGTH_LONG).show();
                } else {
                    if (two_digit.isChecked()) {
                        intent.putExtra("two", true);
                    }
                    if (three_digit.isChecked()) {
                        intent.putExtra("three", true);
                    }
                    if (four_digit.isChecked()) {
                        intent.putExtra("four", true);
                    }
                    startActivity(intent);
                }
            }
        });
    }
}