package com.example.joliver_pc.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Bacon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bacon);
    }

    public void onClick(View v) {
        Intent intent = new Intent(this, Apple.class);
        //switch back from this to Apple
        startActivity(intent);
    }
}
