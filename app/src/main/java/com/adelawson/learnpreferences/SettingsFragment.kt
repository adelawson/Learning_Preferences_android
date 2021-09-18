package com.adelawson.learnpreferences

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.preference.*


class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings, rootKey)

        val prefManager = PreferenceManager.getDefaultSharedPreferences(context)
        val theme = prefManager.getString("theme", "0" )
        Log.i("theme", "Theme_Value: $theme")

//        val dimview = view?.findViewById<View>(R.id.imageView_dim)

        val barPref = findPreference<SeekBarPreference>("bar")
        barPref?.updatesContinuously = true
//        barPref?.onPreferenceChangeListener =
//            Preference.OnPreferenceChangeListener { preference, newValue ->
//                TODO("Not yet implemented")
//
//                val newProgressVal = newValue.
//
//            }



//        val themePref = findPreference<ListPreference>("theme")
//        themePref?.setOnPreferenceChangeListener(object :Preference.OnPreferenceChangeListener{
//            override fun onPreferenceChange(preference: Preference?, newValue: Any?): Boolean {
//                Log.i("TAG", "onPreferenceChange:$newValue ")
//                when(newValue){
//                    "0"->Log.i("Light", "onPreferenceChange:$newValue ")
//                    "1"->Log.i("Dark", "onPreferenceChange:$newValue ")
//                    "3"->Log.i("sys_default", "onPreferenceChange:$newValue ")
//                }
//
//                return true
//            }

//        })
    }
}