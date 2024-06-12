package com.example.travelmate

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.travelmate.ui.theme.HomepageActivity


class MapList : Fragment() {

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_map_list, container, false)

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as? HomepageActivity)?.setSupportActionBar(view.findViewById(R.id.toolbar))
        (activity as? HomepageActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as? HomepageActivity)?.supportActionBar?.setDisplayShowHomeEnabled(true)
        (activity as? HomepageActivity)?.supportActionBar?.setHomeAsUpIndicator(R.drawable.arrow_back)
        (activity as? HomepageActivity)?.supportActionBar?.title = "DESTINATION MAP "

        val toolbar = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        toolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }

        val direction = view.findViewById<View>(R.id.imageView1)
        direction.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:-6.598615,106.799317?q=-6.598615,106.799317(Kebun Raya Bogor)")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

        val direction2 = view.findViewById<View>(R.id.imageView2)
        direction2.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:-6.700333,106.985690?q=-6.700333,106.985690(Puncak)")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

        val direction3 = view.findViewById<View>(R.id.imageView3)
        direction3.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:-6.714824,106.951085?q=-6.714824,106.951085(Taman Safari)")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }



        val SemuaTextView: TextView = view.findViewById<TextView>(R.id.semua)
        SemuaTextView.setOnClickListener {
            val destinationFragment = DestinationFragment()
            replaceFragment(destinationFragment)
        }

        val WisataAlam: TextView = view.findViewById<TextView>(R.id.wisata_alam)
        WisataAlam.setOnClickListener {
            val wisataAlamFragment = WisataAlamFragment()
            replaceFragment(wisataAlamFragment)
        }

        val WisataSejarah: TextView = view.findViewById<TextView>(R.id.wisata_sejarah)
        WisataSejarah.setOnClickListener {
            val wisataSejarahFragment = WisataSejarahFragment()
            replaceFragment(wisataSejarahFragment)
        }

        val WisataKuliner: TextView = view.findViewById<TextView>(R.id.wisata_kuliner)
        WisataKuliner.setOnClickListener {
            val wisataKulinerFragment = WisataKulinerFragment()
            replaceFragment(wisataKulinerFragment)
        }

    }
    private fun replaceFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container,fragment)
            .addToBackStack(null)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }
}
