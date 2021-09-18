package com.adelawson.learnpreferences

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.Preference
import androidx.preference.PreferenceManager

class ChatWindow:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chat_window)
        val prefManager = PreferenceManager.getDefaultSharedPreferences(this)
        val dimVal = prefManager.getInt("bar", 50).toFloat().div(100f)
        val dimmer: View = findViewById<View>(R.id.imageView_dim)
        dimmer.alpha = dimVal
    }
}