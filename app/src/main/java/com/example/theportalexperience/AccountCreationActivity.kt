package com.example.theportalexperience

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseUser

class AccountCreationActivity : AppCompatActivity() {

    private lateinit var emailPasswordHelper: EmailPasswordHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_creation)

        // Initialize EmailPasswordHelper
        emailPasswordHelper = EmailPasswordHelper(this)

        // Find UI elements
        val emailField: EditText = findViewById(R.id.emailField)
        val passwordField: EditText = findViewById(R.id.passwordField)
        val createAccountButton: Button = findViewById(R.id.createAccountButton)

        // Set click listener for the "Create Account" button
        createAccountButton.setOnClickListener {
            val email = emailField.text.toString().trim()
            val password = passwordField.text.toString().trim()

            // Validate email and password
            if (email.isNotEmpty() && password.isNotEmpty()) {
                emailPasswordHelper.createAccount(email, password) { user: FirebaseUser? ->
                    if (user != null) {
                        Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show()
                        navigateToMainActivity()
                    } else {
                        Toast.makeText(this, "Account creation failed", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Email and password must not be empty", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
