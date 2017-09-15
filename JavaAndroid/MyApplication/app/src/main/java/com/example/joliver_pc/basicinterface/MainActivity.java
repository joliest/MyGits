package com.example.joliver_pc.basicinterface;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
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


        //convert DCP(Density/Device independent pixels) to px -
        // DCP allows you to make the size of the widget to appear the same to different screen sizes
        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, r.getDisplayMetrics());

        //setWidth() only accepts "px"
        text.setWidth(px);

        textDetails.addRule(RelativeLayout.ABOVE, button.getId());
        textDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);

        textDetails.setMargins(0,0,0,5); //margin above button (bottom margin, setMargins(l, t, r, b))

        //adding the widget using addView() method
        myLayout.addView(button, buttonDetails);
        myLayout.addView(text, textDetails);

        setContentView(myLayout);

    }
}
