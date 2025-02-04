package com.example.theportalexperience

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class AdvancedFoodActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advanced_food)

        try {
            // Reference the VideoView and set up the video
            val videoView: VideoView = findViewById(R.id.foodVideoView)
            val videoPath = "android.resource://${packageName}/raw/food_video"
            videoView.setVideoURI(Uri.parse(videoPath))

            // Start video and loop it
            videoView.setOnPreparedListener { mediaPlayer ->
                mediaPlayer.isLooping = true
                videoView.start()
            }

            // ✅ Scan My Food button - Navigates to the Camera Scanner Page
            val scanButton = findViewById<Button>(R.id.btnScanFood)
            scanButton.setOnClickListener {
                val intent = Intent(this, FoodScannerActivity::class.java)
                startActivity(intent)
            }

            // ✅ Food Inventory button - Navigates to the Food Inventory Page
            val btnFoodInventory: Button = findViewById(R.id.btnFoodInventory)
            btnFoodInventory.setOnClickListener {
                val intent = Intent(this, FoodInventoryActivity::class.java)
                startActivity(intent)
            }

            // ✅ Manual Entry button - Navigates to the Manual Entry Page
            val manualEntryButton = findViewById<Button>(R.id.btnManualEntry)
            manualEntryButton.setOnClickListener {
                val intent = Intent(this, ManualEntryActivity::class.java)
                startActivity(intent)
            }

        } catch (e: Exception) {
            e.printStackTrace() // Log the exception to debug errors
        }

        val dailyIntakeButton = findViewById<Button>(R.id.btnDailyIntake)
        dailyIntakeButton.setOnClickListener {
            val intent = Intent(this, DailyIntakeActivity::class.java)
            startActivity(intent)
        }

        // ✅ Bottom Navigation Menu Setup
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
    }
}
