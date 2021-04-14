package com.example.activitylifecycle

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class AirplaneModeChangedReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        val isAirplaneModeEnabled = intent?.getBooleanExtra("state", false) ?: return
        if(isAirplaneModeEnabled){
            Toast.makeText(context, "Airplane Mode activated", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(context, "Airplane Mode Deactivated", Toast.LENGTH_LONG).show()
        }

    }
}