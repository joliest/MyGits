package com.example.joliver_pc.sendingextraintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Bacon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bacon);

        //getting the Intent and extras from Bundle
        Bundle applesMessage = getIntent().getExtras();
        if(applesMessage == null) {
            return;
        }

        //getting the extra intent named "applesMessage"
        String messageFromApple = applesMessage.getString("applesMessage");

        final TextView baconText = (TextView) findViewById(R.id.baconText);
        baconText.setText(messageFromApple);
    }

    public void onClick(View v) {
        //go back to apple
        Intent i = new Intent(this, Apple.class);
        startActivity(i);
    }
}
