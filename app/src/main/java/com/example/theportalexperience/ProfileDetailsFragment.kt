package com.example.theportalexperience

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.theportalexperience.R.layout.fragment_profile_details
import com.google.firebase.firestore.FirebaseFirestore

class ProfileDetailsFragment : Fragment() {


    private lateinit var firstName: EditText
    private lateinit var lastName: EditText
    private lateinit var save: Button
    private lateinit var cancel: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(fragment_profile_details, container, false)

        val firestore = FirebaseFirestore.getInstance()
        firstName = view.findViewById(R.id.fName)
        lastName = view.findViewById(R.id.lName)
        save = view.findViewById(R.id.save)
        cancel = view.findViewById(R.id.cancel_action)

        save.setOnClickListener {
            val userData = hashMapOf(
                "First Name" to firstName.text.toString().trim(),
                "Last Name" to lastName.text.toString().trim(),
            ) // Creates hash map for information to be input into the database

            firestore.collection("User")
                .add(userData)
                .addOnSuccessListener { documentReference ->
                    Log.d("Firestore", "DocumentSnapshot added with ID: ${documentReference.id}")
                    val intent = Intent(requireContext(), MainActivity::class.java)
                    startActivity(intent)
                }
                .addOnFailureListener { e ->
                    Log.w("Firestore", "Error adding document", e) } // reports on success of failure of addition

            //parentFragmentManager.popBackStack() // Opens Home Screen on successful input
        }
        return view
    }
}