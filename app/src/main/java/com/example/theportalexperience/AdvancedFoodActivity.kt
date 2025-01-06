package com.example.theportalexperience

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class AdvancedFoodActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_advanced_food)

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

            // Scan My Food button
            val scanButton = findViewById<Button>(R.id.btnScanFood)
            scanButton.setOnClickListener {
                val intent = Intent(this, FoodScannerActivity::class.java)
                startActivity(intent)
            }
        } catch (e: Exception) {
            e.printStackTrace() // Log the exception to see the root cause
        }
    }
}
