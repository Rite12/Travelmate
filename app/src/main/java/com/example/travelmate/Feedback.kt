package com.example.travelmate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.travelmate.ui.theme.HomepageActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class FeedbackFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feedback, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        (activity as? HomepageActivity)?.setSupportActionBar(view.findViewById(R.id.toolbar))
        (activity as? HomepageActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as? HomepageActivity)?.supportActionBar?.setDisplayShowHomeEnabled(true)
        (activity as? HomepageActivity)?.supportActionBar?.setHomeAsUpIndicator(R.drawable.arrow_back)
        (activity as? HomepageActivity)?.supportActionBar?.title = "KRITIK DAN SARAN"

        val toolbar = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        toolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }

        val etUsername: EditText = view.findViewById(R.id.et_username)
        val etMessage: EditText = view.findViewById(R.id.et_message)
        val btnSend: Button = view.findViewById(R.id.btn_send)

        btnSend.setOnClickListener {
            val username = etUsername.text.toString()
            val message = etMessage.text.toString()

            if (message.isBlank()) {
                return@setOnClickListener
            }

            sendFeedbackToFirestore(username, message)
        }
    }

    private fun sendFeedbackToFirestore(username: String, message: String) {
        val currentUser = auth.currentUser
        if (currentUser != null) {
            val feedback = hashMapOf(
                "username" to username,
                "message" to message,
                "userId" to currentUser.uid
            )

            db.collection("feedback")
                .add(feedback)
                .addOnSuccessListener {
                }
                .addOnFailureListener {
                }
        }
    }
}
        data class Feedback(val username: String, val message: String, val userId: String)