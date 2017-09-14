package com.example.joliver_pc.basicinterface;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //create a RelativeLayout instance
        RelativeLayout myLayout = new RelativeLayout(this);
        myLayout.setBackgroundColor(Color.LTGRAY);

        //Layout parameters is just a rules that you want to do
        RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);

        //create a button
        Button button = new Button(this);
        button.setText("Click Me");
        button.setBackgroundColor(Color.GREEN);

        //adding the widget using addView() method
        myLayout.addView(button, buttonDetails);

        setContentView(myLayout);

    }
}
