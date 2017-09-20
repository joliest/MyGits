package com.example.joliver_pc.animationandtransition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.transition.TransitionManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/*
    API LEvel should be 19 or kitkat, to change the API level
    Go to File >> Project Structure >> app >> flavor
*/

public class MainActivity extends AppCompatActivity {

    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        layout = (RelativeLayout) findViewById(R.id.myLayout);

        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                moveButton();
                return true;
            }
        });
    }
    public void moveButton() {
        View myButton = findViewById(R.id.myButton);

        //add this to start transition
        TransitionManager.beginDelayedTransition(layout);

        //change the position of the button
        RelativeLayout.LayoutParams goToBottomRight = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        //With or without RelativeLayout.TRUE, it will work
        goToBottomRight.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        goToBottomRight.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        myButton.setLayoutParams(goToBottomRight);

        //change the size of the button
        ViewGroup.LayoutParams sizeRules = myButton.getLayoutParams(); //returning information about the button itself
        sizeRules.width = 450;
        sizeRules.height = 300;
        myButton.setLayoutParams(sizeRules);


    }
}
