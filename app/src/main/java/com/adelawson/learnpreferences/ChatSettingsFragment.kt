package com.adelawson.learnpreferences

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat

class ChatSettingsFragment:PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.chat_settings, rootKey)

        val navHostFragment = activity?.supportFragmentManager?.findFragmentById(R.id.nav_host_frag) as NavHostFragment
        val navController = navHostFragment.navController

        val wallpaperPref = findPreference<Preference>("wallpaper")
        wallpaperPref?.setOnPreferenceClickListener {

            val action = ChatSettingsFragmentDirections.actionChatSettingsFragmentToFragmentWallpaperSettings()
            navController.navigate(action)
            true
        }

    }


}