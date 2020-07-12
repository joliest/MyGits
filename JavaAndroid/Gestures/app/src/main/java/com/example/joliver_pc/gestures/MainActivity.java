package com.example.joliver_pc.gestures;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.*;
import android.view.MotionEvent;
import android.widget.TextView;
import android.support.v4.view.GestureDetectorCompat;

public class MainActivity extends AppCompatActivity implements OnGestureListener, OnDoubleTapListener{

    private TextView joliverMessage;
    private GestureDetectorCompat gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        joliverMessage = (TextView) findViewById(R.id.joliverMessage); // get the TextView from the xml file
        this.gestureDetector = new GestureDetectorCompat(this, this);  // detects Gesture on this screen
        gestureDetector.setOnDoubleTapListener(this);                  // detects double tap
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        this.gestureDetector.onTouchEvent(e); //pass the event into  GestureDetectorCompat
        return super.onTouchEvent(e);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        joliverMessage.setText("onDown");
        return true; //set this to true to return to its pre-status
    }

    @Override
    public void onShowPress(MotionEvent e) {
        joliverMessage.setText("onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        joliverMessage.setText("onSingleTapUp ");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        joliverMessage.setText("onScroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        joliverMessage.setText("onLongPress");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        joliverMessage.setText("onFling");
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        joliverMessage.setText("onSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        joliverMessage.setText("onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        joliverMessage.setText("onDoubleTapEvent");
        return true;
    }
//this is a comment
}
