package com.example.courseworkapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    // Time in milliseconds that the splash screen will be displayed
    private static final int SPLASH_TIMEOUT = 100;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Delay the transition to the next activity by using a Handler
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                // Begin the IntroSliderMain activity by creating an Intent
                Intent intent = new Intent(SplashScreen.this, IntroSliderMain.class);
                startActivity(intent);

                // Finish the current SplashScreen activity to prevent returning to it on back press
                finish();
            }
        }, SPLASH_TIMEOUT);
    }
}