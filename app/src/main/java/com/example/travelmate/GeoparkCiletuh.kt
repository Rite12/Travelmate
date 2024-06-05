package com.example.travelmate

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.net.Uri
import androidx.fragment.app.FragmentTransaction
import com.example.travelmate.ui.theme.HomepageActivity

class GeoparkCiletuh : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_geopark_ciletuh, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as? HomepageActivity)?.setSupportActionBar(view.findViewById(R.id.toolbar))
        (activity as? HomepageActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as? HomepageActivity)?.supportActionBar?.setDisplayShowHomeEnabled(true)
        (activity as? HomepageActivity)?.supportActionBar?.setHomeAsUpIndicator(R.drawable.arrow_back)
        (activity as? HomepageActivity)?.supportActionBar?.title = "Geopark Ciletuh"

        val toolbar = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        toolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }
        val direction = view.findViewById<View>(R.id.direction_button)
        direction.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:-6.985564,106.410934?q=-6.985564,106.410934(Geopark Ciletuh)")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
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
