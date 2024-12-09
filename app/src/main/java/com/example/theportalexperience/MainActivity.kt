package com.example.theportalexperience

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import com.example.theportalexperience.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1: Button = findViewById(R.id.button1)
        button1.setOnClickListener {
            val intent = Intent(this, PersonalHealthActivity::class.java)
            startActivity(intent)
        }

        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener {
            val intent = Intent(this, AdvancedFoodActivity::class.java)
            startActivity(intent)
        }

        val button3: Button = findViewById(R.id.button3)
        button3.setOnClickListener {
            val intent = Intent(this, RecipeAndDietActivity::class.java)
            startActivity(intent)
        }
    }
}