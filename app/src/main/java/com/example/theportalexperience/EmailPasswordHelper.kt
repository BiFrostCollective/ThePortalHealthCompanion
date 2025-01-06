package com.example.theportalexperience

import android.app.Activity
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class EmailPasswordHelper(private val activity: Activity) {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun createAccount(email: String, password: String, onComplete: (FirebaseUser?) -> Unit) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    onComplete(user)
                } else {
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    showToast("Authentication failed: ${task.exception?.localizedMessage}")
                    onComplete(null)
                }
            }
    }

    fun signIn(email: String, password: String, onComplete: (FirebaseUser?) -> Unit) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    onComplete(user)
                } else {
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    showToast("Authentication failed: ${task.exception?.localizedMessage}")
                    onComplete(null)
                }
            }
    }

    private fun showToast(message: String) {
        Toast.makeText(activity.baseContext, message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val TAG = "EmailPasswordHelper"
    }
}

