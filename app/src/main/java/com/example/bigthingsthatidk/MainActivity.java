package com.example.bigthingsthatidk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView ClockTimer;

    private CountDownTimer countDownTimer;
    private long timeleftmls = 300000; //60000 = 1'
    private boolean TimerRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ClockTimer = findViewById(R.id.ClockTimer);
        StartTimer();

    }

    public void StartTimer() {
        countDownTimer = new CountDownTimer(timeleftmls, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeleftmls = millisUntilFinished;
                updateTimer();
            }

            @Override
            public void onFinish() {
                Intent intentEnd = new Intent(MainActivity.this, EndScreen.class);
                startActivity(intentEnd);
            }
        }
        .start();
        TimerRunning = true;
    }

    public void updateTimer() {
        int minutes = (int) timeleftmls / 60000;
        int second = (int) timeleftmls % 60000 / 1000;

        String timeLeftText;
        timeLeftText = "" + minutes;
        timeLeftText += ":";
        if(second < 10) timeLeftText += "0";
        timeLeftText += second;
        ClockTimer.setText(timeLeftText);
    }
}
