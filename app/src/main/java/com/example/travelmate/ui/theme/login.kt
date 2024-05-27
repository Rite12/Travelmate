package com.example.travelmate.ui.theme

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.travelmate.MainActivity
import com.example.travelmate.R

class LoginActivity : AppCompatActivity() {
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var rememberMeCheckBox: CheckBox
    private lateinit var forgotPasswordTextView: Button
    private lateinit var googleLoginButton: Button
    private lateinit var facebookLoginButton: Button
    private lateinit var appleLoginButton: Button
    private lateinit var signUpButton: Button
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        rememberMeCheckBox = findViewById(R.id.rememberMeCheckBox)
        loginButton = findViewById(R.id.loginButton)

        sharedPreferences = getSharedPreferences("loginPrefs", Context.MODE_PRIVATE)

        checkLoginStatus()

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (authenticateUser(email, password)) {
                if (rememberMeCheckBox.isChecked) {
                    saveLoginDetails(email, password)
                } else {
                    clearLoginDetails()
                }
                navigateToHome()
            } else {
                Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkLoginStatus() {
        val isRemembered = sharedPreferences.getBoolean("rememberMe", false)
        if (isRemembered) {
            val savedEmail = sharedPreferences.getString("email", "")
            val savedPassword = sharedPreferences.getString("password", "")
            if (authenticateUser(savedEmail, savedPassword)) {
                navigateToHome()
            }
        }
    }

    private fun authenticateUser(email: String?, password: String?): Boolean {
        // Replace this with your actual authentication logic
        return email == "***@gmail.com" && password == "password"
    }

    private fun saveLoginDetails(email: String, password: String) {
        val editor = sharedPreferences.edit()
        editor.putBoolean("rememberMe", true)
        editor.putString("email", email)
        editor.putString("password", password)
        editor.apply()
    }

    private fun clearLoginDetails() {
        val editor = sharedPreferences.edit()
        editor.remove("rememberMe")
        editor.remove("email")
        editor.remove("password")
        editor.apply()
    }

    private fun navigateToHome() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}