package com.example.joliver_pc.sendingextraintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.EditText;


public class Apple extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apple);
    }

    public void onClick(View v) {
        Intent i = new Intent(this, Bacon.class); //switch to Bacon.class

        final EditText applesInput = (EditText) findViewById(R.id.applesInput);
        String userMessage = applesInput.getText().toString();

        //like setAttributes() in servlet, it's like allowing this data to be
        //accessible somewhere else
        //i.putExtra(String name, Object message);
        i.putExtra("applesMessage", userMessage);
        startActivity(i);
    }
}
