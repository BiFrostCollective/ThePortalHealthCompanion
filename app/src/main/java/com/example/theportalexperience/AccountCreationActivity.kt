package com.example.theportalexperience

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore

class AccountCreationActivity : AppCompatActivity() {

    private lateinit var emailPasswordHelper: EmailPasswordHelper
    private lateinit var firstName: EditText
    private lateinit var lastName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_creation)

        firstName = findViewById(R.id.firstName)
        lastName = findViewById(R.id.lastName)
        emailPasswordHelper = EmailPasswordHelper(this)

        val firestore = FirebaseFirestore.getInstance()
        val emailField = findViewById<EditText>(R.id.emailField)
        val passwordField = findViewById<EditText>(R.id.passwordField)
        val confirmPassword = findViewById<EditText>(R.id.confirmPasswordField)
        val saveButton = findViewById<Button>(R.id.createAccountButton)
        val cancelButton = findViewById<Button>(R.id.cancel_button)

        saveButton.setOnClickListener {
            val email = emailField.text.toString().trim()
            val password = passwordField.text.toString().trim()
            val confirm = confirmPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty() || confirm.isEmpty()) {
                Toast.makeText(this, "All fields must be filled.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != confirm) {
                Toast.makeText(this, "Passwords do not match.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            emailPasswordHelper.createAccount(email, password) { user ->
                if (user != null) {
                    handleSuccessfulAccountCreation(firestore)
                } else {
                    Toast.makeText(this, "Account creation failed.", Toast.LENGTH_SHORT).show()
                }
            }
        }

        cancelButton.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun handleSuccessfulAccountCreation(firestore: FirebaseFirestore) {
        val userData = hashMapOf(
            "First Name" to firstName.text.toString().trim(),
            "Last Name" to lastName.text.toString().trim()
        )

        firestore.collection("User")
            .add(userData)
            .addOnSuccessListener {
                Log.d("Firestore", "User data added successfully.")
                moveToMain()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Failed to save user data.", Toast.LENGTH_SHORT).show()
            }
    }

    private fun moveToMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}


