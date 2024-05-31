package com.example.travelmate.ui.theme

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.travelmate.R

class ForgotPasswordActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        val emailEditText: EditText = findViewById(R.id.emailEditText)
        val newPasswordEditText: EditText = findViewById(R.id.NewPasswordEditText)
        val confirmPasswordEditText: EditText = findViewById(R.id.ConfirmPassword)
        val confirmButton: Button = findViewById(R.id.loginButton)

        val registerTextView = findViewById<TextView>(R.id.textview3)
        registerTextView.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        confirmButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val newPassword = newPasswordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()

            if (email.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else if (newPassword != confirmPassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Password reset successful", Toast.LENGTH_SHORT).show()
            }
        }
    }
}