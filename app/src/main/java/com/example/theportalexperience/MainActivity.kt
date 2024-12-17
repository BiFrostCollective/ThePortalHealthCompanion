package com.example.theportalexperience

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Variable declarations for Authentication
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        mAuth = FirebaseAuth.getInstance()
        mGoogleSignInClient = GoogleSignIn.getClient(this,gso)
        val textView = findViewById<TextView>(R.id.name)
        val auth = Firebase.auth
        val user = auth.currentUser

        if (user != null){
            val userName = user.displayName
            textView.text = "Welcome, $userName"
        }
        else{
            // handle the guest login here
        }

        val button2: Button = findViewById(R.id.button1)
        button2.setOnClickListener {
            val intent = Intent(this, AdvancedFoodActivity::class.java)
            startActivity(intent)
        }

        val button3: Button = findViewById(R.id.button3)
        button3.setOnClickListener {
            val intent = Intent(this, RecipeAndDietActivity::class.java)
            startActivity(intent)
        }
        val signOutButton = findViewById<Button>(R.id.logout_button)
        signOutButton.setOnClickListener {
            signOutAndStartSignInActivity()
        }

    }

    private fun signOutAndStartSignInActivity(){
        mAuth.signOut()

        mGoogleSignInClient.signOut().addOnCompleteListener(this){
            val intent = Intent(this@MainActivity, SignInActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}