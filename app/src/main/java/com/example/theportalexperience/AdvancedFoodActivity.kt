package com.example.theportalexperience

import android.net.Uri
import android.os.Bundle
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class AdvancedFoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_advanced_food)

        // Reference the VideoView and set up the video
        val videoView: VideoView = findViewById(R.id.foodVideoView)
        val videoPath = "android.resource://${packageName}/raw/food_video" // Path to video in raw folder
        videoView.setVideoURI(Uri.parse(videoPath))

        // Start video and loop it
        videoView.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.isLooping = true
            videoView.start()
        }
    }
}

