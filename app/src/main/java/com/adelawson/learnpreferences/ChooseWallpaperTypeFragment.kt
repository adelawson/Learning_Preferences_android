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
        val test = view.findViewById<ImageView>(R.id.test_imv)


        selectWallpaper.setOnClickListener {
            setArg(1)
        }
        test.setOnClickListener {
            setArg(2)
        }

    }

    fun setArg( int: Int){
        val navHostFragment = activity?.supportFragmentManager?.findFragmentById(R.id.nav_host_frag) as NavHostFragment
        val navController = navHostFragment.navController
        val action = ChooseWallpaperTypeFragmentDirections.actionChooseWallpaperTypeFragmentToFragmentAccSettings(int)
        navController.navigate(action)

    }

}