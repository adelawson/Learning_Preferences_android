package com.adelawson.learnpreferences

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class SelectWallpaperFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        return inflater.inflate(R.layout.fragment_account_settings, container, false)

    }

    fun setUpRecycler(view: View?, int: Int){

        val context = requireContext()

        var obj:ArrayList<GalleryImage>? = null
        if (int == 1){
            obj = SampleImages.list
        }
        else if (int == 2 ){obj=SampleImages.list_2}

        val imageAdapter = ImageAdapter(context,obj!!)
        val recyclerView = view?.findViewById<RecyclerView>(R.id.gallery_recycler)
        recyclerView?.adapter= imageAdapter
        recyclerView?.setHasFixedSize(false)

        val layoutManager = GridLayoutManager(context,2)
        layoutManager.orientation = RecyclerView.VERTICAL
        recyclerView?.layoutManager = layoutManager

    }
val args:SelectWallpaperFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val number = args.whichList
        setUpRecycler(view,number)

    }
}