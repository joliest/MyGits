package com.example.joliver_pc.broadcastintent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ReceiveBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Toast.makeText(context, "Broadcast has been received", Toast.LENGTH_LONG).show(); //when a broadcasts sends something, a message will pop up, context, message and duration
    }
}
