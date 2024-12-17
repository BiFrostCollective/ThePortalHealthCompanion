package com.example.theportalexperience

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AccountCreationActivity : AppCompatActivity() {

    private lateinit var emailPasswordHelper: EmailPasswordHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_creation)

        // Initialize EmailPasswordHelper
        emailPasswordHelper = EmailPasswordHelper(this)

        // Find UI elements
        val emailField = findViewById<EditText>(R.id.emailField)
        val passwordField = findViewById<EditText>(R.id.passwordField)
        val createAccountButton = findViewById<Button>(R.id.createAccountButton)

        // Create Account Button Logic
        createAccountButton.setOnClickListener {
            val email = emailField.text.toString().trim()
            val password = passwordField.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                emailPasswordHelper.createAccount(email, password) { user ->
                    if (user != null) {
                        navigateToMainActivity()
                    }
                }
            }
        }
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
