package com.example.joliver_pc.eventhandling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button joliverButton = (Button) findViewById(R.id.joliverButton);

        joliverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText joliverText = (EditText) findViewById(R.id.joliverText);
                joliverText.setText("Oh Yeah");
            }
        });

        joliverButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                EditText joliverText = (EditText) findViewById(R.id.joliverText);
                joliverText.setText("Longggg hold baby!");

                //tells the compiler to let the longOnClick value to stay
                return true;
            }
        });
    }
}
