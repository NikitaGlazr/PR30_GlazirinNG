package com.example.pr30_glazirinng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    final String LOG_TAG = "myLogs1234";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickStart(View v) {
        startService(new Intent(this, MyService.class));
        Log.d(LOG_TAG, "Service started");
    }

    public void onClickStop(View v) {
        stopService(new Intent(this, MyService.class));
        Log.d(LOG_TAG, "Service stopped");
    }
}