package com.adelawson.learnpreferences

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.Preference
import androidx.preference.PreferenceManager

class ChatWindow:AppCompatActivity(),SharedPreferences.OnSharedPreferenceChangeListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chat_window)

        val prefMng = PreferenceManager.getDefaultSharedPreferences(this)
        val theme = prefMng.getString("theme","0")
        when(theme){
            "0"-> dimView.alpha=0.2f
            "1"-> dimView.alpha=0.5f
            "2"-> dimView.alpha=0.9f
        }

    }
    val dimView = findViewById<View>(R.id.imageView_dim)
    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        if (key == "theme"){
            val newTheme = sharedPreferences?.getString("theme","0")
            when(newTheme){
                "0"-> dimView.alpha=0.2f
                "1"-> dimView.alpha=0.5f
                "2"-> dimView.alpha=0.9f
            }
        }
    }


}