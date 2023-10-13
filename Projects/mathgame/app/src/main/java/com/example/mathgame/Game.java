package com.example.mathgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class Game extends AppCompatActivity {
    Button ok_button;
    Button next_question;
    TextView score;
    TextView life;
    TextView time;
    TextView question;
    EditText answer;

    Random random = new Random();
    int number1;
    int number2;

    int userAns;

    int realAns;
    int userScore = 0;
    int userLife = 3;

    CountDownTimer timer;

    private static final long START_TIMER_IN_MILLIS = 10000;
    boolean timerRunning;
    long timeLeft_in_millis = START_TIMER_IN_MILLIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        score = findViewById(R.id.score);
        life = findViewById(R.id.Lives);
        time = findViewById(R.id.Time);
        ok_button = findViewById(R.id.button_ok);
        next_question = findViewById(R.id.button_nextQ);
        question = findViewById(R.id.question);
        answer = findViewById(R.id.answer);

        gameContinue();

        ok_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer.getText().toString().isEmpty()) {
                    Toast.makeText(Game.this, "Please enter a valid number", Toast.LENGTH_SHORT).show();
                } else {
                    userAns = Integer.valueOf(answer.getText().toString());

                    pauseTimer();

                    if (userAns == realAns) {
                        userScore += 10;
                        question.setText("Congratulation your answer is correct");
                        score.setText("" + userScore);// convert to string value
                        ok_button.setClickable(false);
                    } else {
                        userLife -= 1;
                        life.setText("" + userLife);
                        question.setText("Your answer is wrong");
                        if (userLife == 0) {
                            Toast.makeText(Game.this, "Game Over", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(Game.this, Result.class);
                            intent.putExtra("score", userScore);
                            startActivity(intent);
                            finish();
                        }
                    }
                }
            }
        });

        next_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer.setText("");
                resetTimer();
                gameContinue();
                ok_button.setClickable(true);
            }
        });

    }

    public void gameContinue() {
        number1 = random.nextInt(100);
        number2 = random.nextInt(100);

        realAns = number1 + number2;

        question.setText(number1 + " + " + number2);
        startTimer();
    }

    public void startTimer() {
        timer = new CountDownTimer(timeLeft_in_millis, 1000) {
            @Override // l = millis until finished
            public void onTick(long l) {
                timeLeft_in_millis = l;
                updateText();
            }

            @Override
            public void onFinish() {
                timerRunning = false;
                pauseTimer();
                resetTimer();
                updateText();
                userLife -= 1;
                life.setText(""+userLife);
                question.setText("Time is up");
            }
        }.start();

        timerRunning = true;
    }

    private void updateText() {
        int second = (int) (timeLeft_in_millis / 1000) % 60;
        String time_left = String.format(Locale.getDefault(), "%02d", second);
        time.setText(time_left);
    }

    private void resetTimer() {
        timeLeft_in_millis = START_TIMER_IN_MILLIS;
        updateText();
    }

    private void pauseTimer() {
        timer.cancel();
        timerRunning = false;
    }
}