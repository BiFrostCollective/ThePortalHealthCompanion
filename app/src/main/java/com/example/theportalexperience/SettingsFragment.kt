package com.example.theportalexperience

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import com.example.theportalexperience.R.layout.fragment_settings


class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(fragment_settings, container, false)
        val saveButton: ImageButton = view.findViewById(R.id.backButton)
        saveButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        val privacySecurity: ImageButton = view.findViewById(R.id.privacyButton)
        privacySecurity.setOnClickListener{
            val fragment = PrivacyandSecurityFragment()
            val fragmentTransaction = parentFragmentManager.beginTransaction()

            fragmentTransaction.replace(R.id.frame_layout, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        // Inflate the layout for this fragment
        return view
    }

}

// supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)