package com.example.travelmate.ui.theme

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.travelmate.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class RegisterActivity : AppCompatActivity() {

    private lateinit var NameEditText: EditText
    private lateinit var EmailEditText:EditText
    private lateinit var PhoneEditText:EditText
    private lateinit var PasswordEditText:EditText
    private lateinit var daftar:Button
    private lateinit var auth: FirebaseAuth
    private lateinit var db : FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        NameEditText = findViewById(R.id.Name)
        EmailEditText= findViewById(R.id.Email)
        PhoneEditText = findViewById(R.id.Phone)
        PasswordEditText = findViewById(R.id.Password)
        daftar = findViewById(R.id.daftar)
        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        val textView6 = findViewById<TextView>(R.id.textView6)
        textView6.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        daftar.setOnClickListener{
            registerUser()
        }
    }

    private fun registerUser() {
        val email = EmailEditText.text.toString().trim()
        val password = PasswordEditText.text.toString().trim()
        val name = NameEditText.text.toString().trim()
        val phone = PhoneEditText.text.toString().trim()

        if (email.isNotBlank() && password.isNotBlank() && name.isNotBlank() && phone.isNotBlank()) {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = hashMapOf(
                            "name" to name,
                            "email" to email,
                            "phone" to phone
                        )
                        db.collection("users").document(auth.currentUser!!.uid)
                            .set(user)
                            .addOnSuccessListener {
                                Toast.makeText(this, "Registrasi Berhasil", Toast.LENGTH_SHORT).show()
                                val intent = Intent(this, LoginActivity::class.java)
                                startActivity(intent)
                                finish()
                            }
                            .addOnFailureListener {
                                Toast.makeText(this, "Gagal Menyimpan data", Toast.LENGTH_SHORT).show()
                            }
                    } else {
                        Toast.makeText(this, "Registrasi Gagal.", Toast.LENGTH_SHORT).show()
                    }
                }
        } else {
            Toast.makeText(this, "Harus Diisi semuanya.", Toast.LENGTH_SHORT).show()
        }
    }
}

