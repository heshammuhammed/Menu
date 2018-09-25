package com.example.heshammuhammed.menu.BroadcastReceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.heshammuhammed.menu.View.MainScreen;

/**
 * Created by HeshamMuhammed on 9/25/2018.
 */

// Receiver to Open Application When Mobile Starts

public class Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent myIntent = new Intent(context, MainScreen.class);
        myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(myIntent);
    }
}
