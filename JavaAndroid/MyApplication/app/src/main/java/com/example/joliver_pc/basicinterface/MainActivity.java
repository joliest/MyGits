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

        //create a button
        Button button = new Button(this);
        button.setText("Click Me");
        button.setBackgroundColor(Color.GREEN);

        //text field
        EditText text = new EditText(this);

        //set the Id to arrange the text and button
        button.setId(1);
        text.setId(2);


        //Layout parameters is just a rules that you want to do
        RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        RelativeLayout.LayoutParams textDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);

        textDetails.addRule(RelativeLayout.ABOVE, button.getId());
        textDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        //margin above button
        textDetails.setMargins(0,0,0,5); //left, top, right, bottom

        //adding the widget using addView() method
        myLayout.addView(button, buttonDetails);
        myLayout.addView(text, textDetails);

        setContentView(myLayout);

    }
}
