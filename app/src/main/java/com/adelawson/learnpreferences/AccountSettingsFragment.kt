package com.adelawson.learnpreferences

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class AccountSettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        return inflater.inflate(R.layout.fragment_account_settings, container, false)

    }

    fun setUpRecycler(view: View?){

        val context = requireContext()
        val imageAdapter = ImageAdapter(context,SampleImages.list_2!!)
        val recyclerView = view?.findViewById<RecyclerView>(R.id.gallery_recycler)
        recyclerView?.adapter= imageAdapter
        recyclerView?.setHasFixedSize(true)

        val layoutManager = GridLayoutManager(context,2)
        layoutManager.orientation = RecyclerView.VERTICAL
        recyclerView?.layoutManager = layoutManager

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecycler(view)

    }
}