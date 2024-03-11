package com.example.androidactivitylifecycle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int threadCounter = 0;
    int restartCounter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        restartCounter ++;

        TextView threadCounterText = findViewById(R.id.thread_counter_txt);
        threadCounterText.setText("ThreadCounter: " + String.valueOf(threadCounter)+"\nRestartCounter: " +String.valueOf(restartCounter));
    }

    public void onStartActivityB(View view) {
        threadCounter += 5;
        Intent activityBIntent = new Intent(MainActivity.this, ActivityB.class);
        startActivity(activityBIntent);
    }

    public void onStartActivityC(View view) {
        threadCounter += 10;
        Intent activityCIntent = new Intent(MainActivity.this, ActivityC.class);
        startActivity(activityCIntent);
    }

    public void onTriggerDialog(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Simple Dialog")
                .setMessage("A Sample Dialog")
                .setPositiveButton(android.R.string.yes, null)
                .show();
    }

    public void onCloseApp(View view) {
        finish();
        System.exit(0);
    }
}