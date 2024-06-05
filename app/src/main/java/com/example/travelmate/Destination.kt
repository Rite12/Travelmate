package com.example.travelmate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.travelmate.GeoparkCiletuh
import com.example.travelmate.HomeFragment
import com.example.travelmate.R

class DestinationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_destination, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val SemuaTextView: TextView = view.findViewById<TextView>(R.id.semua)
        SemuaTextView.setOnClickListener {
            val destinationFragment = DestinationFragment()
            replaceFragment(destinationFragment)
        }
        val geoparkciletuhImageView : ImageView = view.findViewById<ImageView>(R.id.Destination5)
        geoparkciletuhImageView.setOnClickListener {
            val geoparkciletuhFragment = GeoparkCiletuh()
            replaceFragment(geoparkciletuhFragment)
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
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
            .commit()
    }
}
