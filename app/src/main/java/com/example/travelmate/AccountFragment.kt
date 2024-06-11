package com.example.travelmate

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.travelmate.ui.theme.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class AccountFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_account, container, false)
        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        val tvName = view.findViewById<TextView>(R.id.Name)
        val tvEmail = view.findViewById<TextView>(R.id.Email)
        val tvPhone = view.findViewById<TextView>(R.id.phone)

        val currentUser = auth.currentUser
        currentUser?.let {
            db.collection("users").document(it.uid)
                .get()
                .addOnSuccessListener { document ->
                    if (document != null && document.exists()) {
                        tvName.text = document.getString("name")
                        tvEmail.text = document.getString("email")
                        tvPhone.text = document.getString("phone")
                    } else {
                        Log.d("UserFragment", "No such document")
                    }
                }
                .addOnFailureListener { exception ->
                    Log.d("UserFragment", "get failed with ", exception)
                }
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val logoutTxt: TextView = view.findViewById(R.id.tvLogOut)
        logoutTxt.setOnClickListener {
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
            Toast.makeText(activity, "Logout Berhasil", Toast.LENGTH_SHORT).show()
        }
        val feedback: TextView = view.findViewById(R.id.tvKritikDanSaran)
        feedback.setOnClickListener {
            val feedbackFragment = FeedbackFragment()
            replaceFragment(feedbackFragment)
        }
        val MapListiew: ImageView = view.findViewById<ImageView>(R.id.ic_map)
        MapListiew.setOnClickListener {
            val MapListFragment = MapList()
            replaceFragment(MapListFragment)
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
