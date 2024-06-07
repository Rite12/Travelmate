package com.example.travelmate

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.travelmate.ui.theme.LoginActivity

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_beranda, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val promoBtn: ImageView = view.findViewById(R.id.promo_image)
        val logoutBtn: ImageView = view.findViewById(R.id.Logout)

        promoBtn.setOnClickListener {
            val promoFragment = PromoFragment()
            replaceFragment(promoFragment)
        }
        logoutBtn.setOnClickListener{
            val intent = Intent (activity,LoginActivity::class.java)
            startActivity(intent)
            Toast.makeText(activity, "Logout Berhasil", Toast.LENGTH_SHORT).show()
        }
        val wisataAlam: ImageView = view.findViewById<ImageView>(R.id.wisata_alam)
        wisataAlam.setOnClickListener {
            val wisataAlamFragment = WisataAlamFragment()
            replaceFragment(wisataAlamFragment)
        }
        val kebunRaya : ImageView = view.findViewById<ImageView>(R.id.kebun_raya)
        kebunRaya.setOnClickListener {
            val kebunRayaFragment = KebunRayaFragment()
            replaceFragment(kebunRayaFragment)
        }
        val WisataKuliner: ImageView = view.findViewById<ImageView>(R.id.wisata_kuliner)
        WisataKuliner.setOnClickListener {
            val wisataKulinerFragment = WisataKulinerFragment()
            replaceFragment(wisataKulinerFragment)
        }
        val wisataSejarah: ImageView = view.findViewById<ImageView>(R.id.wisata_sejarah)
        wisataSejarah.setOnClickListener {
            val wisataSejarahFragment = WisataSejarahFragment()
            replaceFragment(wisataSejarahFragment)
        }



    }
    private fun replaceFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
        .replace(R.id.fragment_container, fragment)
        .addToBackStack(null)
        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
        .commit()
        }

}