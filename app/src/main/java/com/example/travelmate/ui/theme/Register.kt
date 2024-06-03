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

class RegisterActivity : AppCompatActivity() {

    private lateinit var NameEditText: EditText
    private lateinit var EmailEditText:EditText
    private lateinit var PhoneEditText:EditText
    private lateinit var PasswordEditText:EditText
    private lateinit var daftar:Button
    private lateinit var auth: FirebaseAuth

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

        if (email.isEmpty()) {
            Toast.makeText(this, "Masukkan email", Toast.LENGTH_SHORT).show()
            return
        }

        if (password.isEmpty()) {
            Toast.makeText(this, "Masukkan password", Toast.LENGTH_SHORT).show()
            return
        }

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Daftar Berhasi
                    Toast.makeText(this, "Registrasi Berhasil", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this,LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    //Daftar Gagal
                    Toast.makeText(this, "Registrasi Gagal: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}
