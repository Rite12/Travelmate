package com.example.travelmate.ui.theme

import AccountFragment
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.travelmate.R
import com.example.myapp.DestinationFragment
import com.example.myapp.HomeFragment
import com.example.myapp.PromoFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class HomepageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation_bar)


        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    // Reload MainActivity to simulate navigating back to home
                    val intent = Intent(this, HomepageActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    startActivity(intent)
                    true
                }
                R.id.navigation_destination -> {
                    loadFragment(DestinationFragment())
                    true
                }
                R.id.navigation_promo -> {
                    loadFragment(PromoFragment())
                    true
                }
                R.id.navigation_account -> {
                    loadFragment(AccountFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: androidx.fragment.app.Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}