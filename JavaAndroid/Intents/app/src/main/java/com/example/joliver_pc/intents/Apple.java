package com.example.joliver_pc.intents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class Apple extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apple);
    }

    public void onClick(View v) {
        Intent intent = new Intent(this, Bacon.class);
        //change the page from this to Bacon
        startActivity(intent);
    }
}
