package com.example.mathgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    Button again;
    Button exit;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        result = findViewById(R.id.textView4);
        again = findViewById(R.id.again);
        exit = findViewById(R.id.exit);

        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Result.this, MainActivity.class);
                startActivity(intent);
                finish(); // close older activity when open new activity
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        getResult();
    }

    public void getResult() {
        Intent result_intent = getIntent();
        Integer score = result_intent.getIntExtra("score",0);
        String userScore = String.valueOf(score);
        result.setText("Score : " + userScore);
    }
}