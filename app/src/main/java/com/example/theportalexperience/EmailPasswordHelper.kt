package com.example.theportalexperience

import android.app.Activity
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class EmailPasswordHelper(private val activity: Activity) {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    // Create a new account
    fun createAccount(email: String, password: String, onComplete: (FirebaseUser?) -> Unit) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    // Account creation successful
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
                    onComplete(user)
                } else {
                    // Account creation failed
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    showToast("Authentication failed: ${task.exception?.localizedMessage}")
                    onComplete(null)
                }
            }
    }

    // Sign in to an existing account
    fun signIn(email: String, password: String, onComplete: (FirebaseUser?) -> Unit) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    // Sign in successful
                    Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                    onComplete(user)
                } else {
                    // Sign in failed
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    showToast("Authentication failed: ${task.exception?.localizedMessage}")
                    onComplete(null)
                }
            }
    }

    // Send email verification
    fun sendEmailVerification(onComplete: (Boolean) -> Unit) {
        val user = auth.currentUser
        user?.sendEmailVerification()
            ?.addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "sendEmailVerification:success")
                    showToast("Verification email sent to ${user.email}")
                    onComplete(true)
                } else {
                    Log.w(TAG, "sendEmailVerification:failure", task.exception)
                    showToast("Failed to send verification email: ${task.exception?.localizedMessage}")
                    onComplete(false)
                }
            }
    }

    // Helper to show Toast messages
    private fun showToast(message: String) {
        Toast.makeText(activity.baseContext, message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val TAG = "EmailPasswordHelper"
    }
}
