package com.example.numberguessing;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private TextView textViewLast, textViewRight, textViewHint;
    private Button buttonConfirm;
    private EditText editTextGuess;

    boolean two_digits, three_digits, four_digits;

    // Creating from a random class
    Random random = new Random();
    int randomNum;

    int remainingRights = 10;

    ArrayList<Integer> guessList = new ArrayList<>();
    int userAttempts = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        textViewLast = findViewById(R.id.textViewLast);
        textViewRight = findViewById(R.id.textViewRight);
        textViewHint = findViewById(R.id.textViewHint);
        buttonConfirm = findViewById(R.id.confirm);
        editTextGuess = findViewById(R.id.editTextGuess);

        two_digits = getIntent().getBooleanExtra("two", false);
        three_digits = getIntent().getBooleanExtra("three", false);
        four_digits = getIntent().getBooleanExtra("four", false);

        if (two_digits) {
            randomNum = random.nextInt(90)+ 10;
        }
        if (three_digits) {
            randomNum = random.nextInt(900)+ 100;
        }
        if (four_digits) {
            randomNum = random.nextInt(9000)+ 1000;
        }

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String guess = editTextGuess.getText().toString();
                if (guess.isEmpty()) {
                    Toast.makeText(GameActivity.this, "Don't leave your guess empty", Toast.LENGTH_SHORT).show();
                } else {
                    textViewLast.setVisibility(View.VISIBLE);
                    textViewRight.setVisibility(View.VISIBLE);
                    textViewHint.setVisibility(View.VISIBLE);

                    userAttempts ++;
                    remainingRights --;

                    int userGuess = Integer.parseInt(guess);
                    guessList.add(userGuess);
                    textViewLast.setText("Your last guess is: " + guess);
                    textViewRight.setText("Your remaining guess is: " + remainingRights);

                    if (randomNum == userGuess) {

                        // WIN THE GAME

                        AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
                        builder.setTitle("Number Guessing Game");
                        builder.setCancelable(false); // click out won't close
                        builder.setMessage("Congratulations, My guess was"
                                + randomNum
                                + "\n\n You know my number in " + userAttempts
                                + " attempts \n\n "
                                + "Your guesses :" + guessList
                                + "\n\n Would you link to play again?");

                        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(GameActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        });

                        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(GameActivity.this, SplashActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        });

                        builder.create().show();

                    } else if (randomNum > userGuess) {

                        textViewHint.setText("Increase your guess");

                    } else {

                        textViewHint.setText("Decrease your guess");

                    }
                    if (remainingRights == 0) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
                        builder.setTitle("Number Guessing Game");
                        builder.setCancelable(false); // click out won't close
                        builder.setMessage("Sorry your right to guess is over"
                                + "\n\n Your guesses :" + guessList
                                + "\n\n Would you link to play again?");

                        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(GameActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        });

                        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(GameActivity.this, SplashActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        });

                        builder.create().show();
                    }
                    editTextGuess.setText("");
                }
            }
        });


    }
}