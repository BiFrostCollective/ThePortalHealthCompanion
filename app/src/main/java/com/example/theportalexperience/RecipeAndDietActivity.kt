package com.example.theportalexperience

import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton
import com.example.theportalexperience.BreakfastFragment
import com.example.theportalexperience.LunchFragment
import com.example.theportalexperience.DinnerFragment
import com.example.theportalexperience.DessertsFragment
import com.example.theportalexperience.BBQFragment
import com.example.theportalexperience.AppetizerFragment
import com.example.theportalexperience.SoupFragment
import com.example.theportalexperience.SnacksFragment
import com.example.theportalexperience.DrinksFragment

class RecipeAndDietActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
                    true
                }
                R.id.settings -> {
                    val fragment = SettingsFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, fragment)
                        .addToBackStack(null)
                        .commit()
                    true
                }
                R.id.back -> {
                    finish()
                    true
                }
                else -> false
            }
        }

        val searchButton = findViewById<MaterialButton>(R.id.searchButton)
        searchButton.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, SearchFragment.newInstance())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        val breakfastButton = findViewById<ImageButton>(R.id.breakfastButton)
        val lunchButton = findViewById<ImageButton>(R.id.lunchButton)
        val dinnerButton = findViewById<ImageButton>(R.id.dinnerButton)
        val dessertsButton = findViewById<ImageButton>(R.id.dessertsButton)
        val bbqButton = findViewById<ImageButton>(R.id.bbqButton)
        val appetizerButton = findViewById<ImageButton>(R.id.appetizerButton)
        val sideDishesButton = findViewById<ImageButton>(R.id.sideDishesButton)
        val snacksButton = findViewById<ImageButton>(R.id.snacksButton)
        val drinksButton = findViewById<ImageButton>(R.id.drinksButton)

        breakfastButton.setOnClickListener {
            Toast.makeText(this, "Breakfast Button Clicked", Toast.LENGTH_SHORT).show()
            navigateToFragment(BreakfastFragment.newInstance())
        }

        lunchButton.setOnClickListener {
            Toast.makeText(this, "Lunch Button Clicked", Toast.LENGTH_SHORT).show()
            navigateToFragment(LunchFragment.newInstance())
        }

        dinnerButton.setOnClickListener {
            Toast.makeText(this, "Dinner Button Clicked", Toast.LENGTH_SHORT).show()
            navigateToFragment(DinnerFragment.newInstance())
        }

        dessertsButton.setOnClickListener {
            Toast.makeText(this, "Desserts Button Clicked", Toast.LENGTH_SHORT).show()
            navigateToFragment(DessertsFragment.newInstance())
        }

        bbqButton.setOnClickListener {
            Toast.makeText(this, "BBQ Button Clicked", Toast.LENGTH_SHORT).show()
            navigateToFragment(BBQFragment.newInstance())
        }

        appetizerButton.setOnClickListener {
            Toast.makeText(this, "Appetizer Button Clicked", Toast.LENGTH_SHORT).show()
            navigateToFragment(AppetizerFragment.newInstance())
        }

        sideDishesButton.setOnClickListener {
            Toast.makeText(this, "Side Dishes Button Clicked", Toast.LENGTH_SHORT).show()
            navigateToFragment(SoupFragment.newInstance())
        }

        snacksButton.setOnClickListener {
            Toast.makeText(this, "Snacks Button Clicked", Toast.LENGTH_SHORT).show()
            navigateToFragment(SnacksFragment.newInstance())
        }

        drinksButton.setOnClickListener {
            Toast.makeText(this, "Drinks Button Clicked", Toast.LENGTH_SHORT).show()
            navigateToFragment(DrinksFragment.newInstance())
        }
    }

    private fun navigateToFragment(fragment: androidx.fragment.app.Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
