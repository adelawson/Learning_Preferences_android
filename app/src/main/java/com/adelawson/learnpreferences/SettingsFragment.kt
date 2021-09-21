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

        val changeWallpaper = findPreference<Preference>("change_wallpaper")
        changeWallpaper?.setOnPreferenceClickListener {
            val navHostFragment = activity?.supportFragmentManager?.findFragmentById(R.id.nav_host_frag) as NavHostFragment
            val navController = navHostFragment.navController
            val action = SettingsFragmentDirections.actionFragmentSettingsToChooseWallpaperTypeFragment()
            navController.navigate(action)
            true

        }


        val theme = prefManager.getString("theme", "0" )
        Log.i("theme", "Theme_Value: $theme")
        val barPref = findPreference<SeekBarPreference>("bar")
        barPref?.updatesContinuously = true

        PreferenceManager.getDefaultSharedPreferences(context).registerOnSharedPreferenceChangeListener(this)

    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        val dimmer:View? = view?.findViewById<View>(R.id.imageView_dim)
        val dimmerBox:View? = view?.findViewById<View>(R.id.dimmer_box)

        if (key == "bar"){

            val barIncr = sharedPreferences?.getInt("bar",50)?.toFloat()
            val flt = barIncr?.div(100.0f)
            if (flt != null) {
                dimmer?.alpha=flt
                dimmerBox?.alpha= flt
            }

        }
    }

}