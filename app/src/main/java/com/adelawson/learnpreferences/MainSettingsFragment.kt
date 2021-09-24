package com.adelawson.learnpreferences

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat

class MainSettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)

        // Setup Nav Controller to handle navigation on Screen

        val navHostFragment = activity?.supportFragmentManager?.findFragmentById(R.id.nav_host_frag) as NavHostFragment
        val navController = navHostFragment.navController

        //navigation to chat settings on-click
        val chatSettings = findPreference<Preference>("chat_settings")
        chatSettings?.setOnPreferenceClickListener {
            val action = MainSettingsFragmentDirections.actionMainSettingsFragmentToFragmentSettings()
            navController.navigate(action)
            true
        }
        //navigation to profile info on-click
        val profileInfo = findPreference<Preference>("profile")
        profileInfo?.setOnPreferenceClickListener {
            val action = MainSettingsFragmentDirections.actionMainSettingsFragmentToProfileInfoFragment()
            navController.navigate(action)
            true
        }
    }
}