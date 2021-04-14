package com.example.activitylifecycle

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    lateinit var receiver: AirplaneModeChangedReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        // use arrayadapter and define an array
//        val arrayAdapter: ArrayAdapter<*>
//        val users = arrayOf(
//                "Virat Kohli", "Rohit Sharma", "Steve Smith",
//                "Kane Williamson", "Ross Taylor"
//        )
//
//        // access the listView from xml file
//        var mListView = findViewById<ListView>(R.id.listView1)
//        arrayAdapter = ArrayAdapter(this,
//                android.R.layout.simple_list_item_1, users)
//        mListView.adapter = arrayAdapter

        receiver = AirplaneModeChangedReceiver()

        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver, it)
        }

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, firstFragment)
            commit()
        }

        val btnFragmentOne = findViewById<Button>(R.id.btnFragment1)
        val btnFragmentTwo = findViewById<Button>(R.id.btnFragment2)

        btnFragmentOne.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, firstFragment)
                addToBackStack(null)
                commit()

            }
        }

        btnFragmentTwo.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, secondFragment)
                addToBackStack(null)
                commit()
            }
        }


    }

    override fun onStart() {
        super.onStart()
        Log.d("activity_lifecycle", "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("activity_lifecycle", "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("activity_lifecycle", "onPause called")
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
        Log.d("activity_lifecycle", "onStop called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("activity_lifecycle", "onRestart called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("activity_lifecycle", "onDestroy called")
    }

}