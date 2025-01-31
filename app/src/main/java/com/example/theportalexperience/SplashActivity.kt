package com.example.theportalexperience

import android.content.Intent
import android.media.tv.TvContract.Programs
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import android.os.CountDownTimer
import android.widget.ProgressBar

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val progressBar: ProgressBar = findViewById(R.id.progressBar)

        // Simulate progress
        val timer = object : CountDownTimer(5000, 50) { // 3 seconds with 50ms interval
            override fun onTick(millisUntilFinished: Long) {
                val progress = (100 - millisUntilFinished / 30).toInt() // Convert time to progress
                progressBar.progress = progress
            }

            override fun onFinish() {
                val intent = Intent(this@SplashActivity, SignInActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        timer.start()
    }
}