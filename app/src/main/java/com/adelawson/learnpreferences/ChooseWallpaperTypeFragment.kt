package com.adelawson.learnpreferences

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment

import android.content.Intent
import androidx.navigation.fragment.NavHostFragment


class ChooseWallpaperTypeFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_choose_wallpaper_type, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val selectWallpaper = view?.findViewById<ImageView>(R.id.select_bright)
        selectWallpaper.setOnClickListener {
//            val message = "yam"
//            val intent = Intent(context, AccountSettingsFragment::class.java)
//            intent.putExtra("clicked_item", message)
//            startActivity(intent)
            val navHostFragment = activity?.supportFragmentManager?.findFragmentById(R.id.nav_host_frag) as NavHostFragment
            val navController = navHostFragment.navController
            val action = ChooseWallpaperTypeFragmentDirections.actionChooseWallpaperTypeFragmentToFragmentAccSettings()
            navController.navigate(action)
        }

    }

}