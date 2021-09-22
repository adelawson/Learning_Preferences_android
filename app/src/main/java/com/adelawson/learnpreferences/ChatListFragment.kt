package com.adelawson.learnpreferences

import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.preference.PreferenceManager


class ChatListFragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_chat_list, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imgcontr = view?.findViewById<ImageView>(R.id.imageView_test)
        val img = view?.findViewById<ImageView>(R.id.imageView6)
        val dimmerBox:View? = view?.findViewById<View>(R.id.dimmer_box)
        val prefMngr = PreferenceManager.getDefaultSharedPreferences(context)
        val dimVal = prefMngr.getInt("bar",50).toFloat().div(100f)
        dimmerBox?.alpha = dimVal
        val btn:View? = view?.findViewById(R.id.btn_dim)
        btn?.setOnClickListener(View.OnClickListener {
            Toast.makeText(context, "this is a sample toast", Toast.LENGTH_SHORT).show()
            
        //            dimmerBox?.alpha= 0.2f
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.chat_list_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.action_settings -> {
                val navHostFragment = activity?.supportFragmentManager?.findFragmentById(R.id.nav_host_frag) as NavHostFragment
                val navController = navHostFragment.navController
                val action = ChatListFragmentDirections.actionChatListToSettings()
                navController.navigate(action)
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
}