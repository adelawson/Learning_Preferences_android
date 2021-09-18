package com.adelawson.learnpreferences

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.preference.*


class SettingsFragment : PreferenceFragmentCompat(),SharedPreferences.OnSharedPreferenceChangeListener {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings, rootKey)
        val prefManager = PreferenceManager.getDefaultSharedPreferences(context)
        val theme = prefManager.getString("theme", "0" )
        Log.i("theme", "Theme_Value: $theme")
        val barPref = findPreference<SeekBarPreference>("bar")
        barPref?.updatesContinuously = true

        PreferenceManager.getDefaultSharedPreferences(context).registerOnSharedPreferenceChangeListener(this)

    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        val dimmer:View? = view?.findViewById<View>(R.id.imageView_dim)

        if (key == "bar"){

            val barIncr = sharedPreferences?.getInt("bar",50)?.toFloat()
            val flt = barIncr?.div(100.0f)
            if (flt != null) {
                dimmer?.alpha=flt
            }

        }
    }
}