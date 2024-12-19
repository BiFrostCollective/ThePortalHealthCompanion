package com.example.theportalexperience


import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class RecipeAndDietActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recipe_and_diet)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val bottomNav = findViewById<BottomNavigationView>(R.id.navBottom)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    finish()
                    // Already in FirstActivity
                    true
                }
                R.id.settings -> {
                    val fragment = SettingsFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.FrameLayout, fragment)
                        .addToBackStack(null)
                        .commit()
                    true
                }
                R.id.back -> {
                    // add back button functionality
                    finish()
                    true
                }
                else -> false
            }
        }
    }
}