package com.example.joliver_pc.broadcastintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
        When you click the button, this method below will run,
        sending signal to the receiver.
        Receiver will then acknowledge and sends the TOAST
     */
    public void sendOutBroadcast(View v) {
        Intent i = new Intent(); //overloaded no arg constructor
        i.setAction("com.example.joliver_pc.broadcastintent"); //will send on this package
        i.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES); //should be compatible to previous android versions
        sendBroadcast(i); //sends broadcast
    }
}
