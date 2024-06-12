package com.example.travelmate.ui.theme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.travelmate.R


class AboutUsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_about_us, container, false)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        (activity as? HomepageActivity)?.setSupportActionBar(view.findViewById(R.id.toolbar))
        (activity as? HomepageActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as? HomepageActivity)?.supportActionBar?.setDisplayShowHomeEnabled(true)
        (activity as? HomepageActivity)?.supportActionBar?.setHomeAsUpIndicator(R.drawable.arrow_back)

        val toolbar = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        toolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }

}
}
