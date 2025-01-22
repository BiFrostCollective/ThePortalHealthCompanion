package com.example.theportalexperience

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth

import com.google.firebase.auth.auth


class MainActivity : AppCompatActivity() {

    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var firebaseAuth: FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val aFoodButton = findViewById<Button>(R.id.foodButton)
        aFoodButton.setOnClickListener {
            val intent = Intent(this, AdvancedFoodActivity::class.java)
            startActivity(intent)
        }

        val recipeButton = findViewById<Button>(R.id.recipeButton)
        recipeButton.setOnClickListener {
            val intent = Intent(this, RecipeAndDietActivity::class.java)
            startActivity(intent)
        }

        val signOutButton = findViewById<Button>(R.id.logout_button)
        signOutButton.setOnClickListener {
            signOutAndStartSignInActivity()
        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.navBottom)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> true
                R.id.settings -> {
                    val fragment = SettingsFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, fragment)
                        .addToBackStack(null)
                        .commit()
                    true
                }
                R.id.back -> {
                    true
                }
                else -> false
            }
        }
    }

    private fun signOutAndStartSignInActivity() {
        firebaseAuth.signOut()
        googleSignInClient.signOut().addOnCompleteListener(this) {
            val intent = Intent(this@MainActivity, SignInActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
