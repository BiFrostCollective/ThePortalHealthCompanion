package com.example.theportalexperience

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class PersonalHealthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_health)

        // Load the fragment into the activity
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, PersonalHealthFragment())
                .commit()
        }
    }
}
