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

//        val prefMng = PreferenceManager.getDefaultSharedPreferences(this)
//        val theme = prefMng.getString("theme","0")
//        when(theme){
//            "0"-> dimView.alpha=0.2f
//            "1"-> dimView.alpha=0.5f
//            "2"-> dimView.alpha=0.9f
//        }

    }
    val dimView = findViewById<View>(R.id.imageView_dim)
//    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
//        if (key == "theme"){
//            Toast.makeText(this, "theme value change", Toast.LENGTH_SHORT).show()
//            val newTheme = sharedPreferences?.getString("theme","0")
//            when(newTheme){
//                "0"-> Toast.makeText(this, "theme value change", Toast.LENGTH_SHORT).show()
//                "1"-> dimView.alpha=0.5f
//                "2"-> dimView.alpha=0.9f
//            }
//        }
//    }

//    override fun onResume() {
//        super.onResume()
//        PreferenceManager.getDefaultSharedPreferences(this).registerOnSharedPreferenceChangeListener(this)
//    }
//    override fun onPause() {
//        super.onPause()
//        PreferenceManager.getDefaultSharedPreferences(this).unregisterOnSharedPreferenceChangeListener(this)
//    }
}