package com.adelawson.learnpreferences

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.preference.PreferenceManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class ChatListFragment : Fragment() {

    val Fragment.packageManager get() = activity?.packageManager


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_chat_list, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imgcontr = view.findViewById<ImageView>(R.id.imageView_test)
        val dimmerBox:View? = view.findViewById<View>(R.id.dimmer_box)
        val prefMngr = PreferenceManager.getDefaultSharedPreferences(context)
        val dimVal = prefMngr.getInt("bar",50).toFloat().div(100f)
        dimmerBox?.alpha = dimVal
        val btn:View? = view.findViewById(R.id.btn_dim)

        btn?.setOnClickListener {
            Toast.makeText(context, "this is a sample toast", Toast.LENGTH_SHORT).show()
        }
    }


    fun dialogue (){
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Confirm Logout")
            .setMessage("Do you really want to logout")
            .setNegativeButton("No"){dialog,which->

                Toast.makeText(requireContext(), "No", Toast.LENGTH_SHORT).show()
                    }
            .setPositiveButton("Yes"){dialog,which->
                Toast.makeText(requireContext(), "Yes", Toast.LENGTH_SHORT).show()
            }
            .show()
    }

    fun dailBamBam(){
        val phoneNumber = "+2349032256477"
        val intent = Intent(Intent.ACTION_CALL).apply {
            data = Uri.parse("tel:$phoneNumber")}
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)

        }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.chat_list_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.action_settings -> {
                val navHostFragment = activity?.supportFragmentManager?.findFragmentById(R.id.nav_host_frag) as NavHostFragment
                val navController = navHostFragment.navController
                val action = ChatListFragmentDirections.actionFragmentChatListToMainSettingsFragment()
                navController.navigate(action)
                return true
            }
            R.id.action_logout->{
                dialogue()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
}