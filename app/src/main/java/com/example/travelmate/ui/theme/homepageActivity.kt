package com.example.travelmate.ui.theme

import AccountFragment
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.travelmate.R
import com.example.myapp.DestinationFragment
import com.example.myapp.HomeFragment
import com.example.myapp.PromoFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class HomepageActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        replaceFragment(HomeFragment())

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation_bar)



        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    // Reload MainActivity to simulate navigating back to home
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.navigation_destination -> {
                    replaceFragment(DestinationFragment())
                    true
                }
                R.id.navigation_promo -> {
                    replaceFragment(PromoFragment())
                    true
                }
                R.id.navigation_account -> {
                    replaceFragment(AccountFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }

}