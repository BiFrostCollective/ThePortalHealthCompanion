package com.example.theportalexperience

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import com.example.theportalexperience.R.layout.fragment_settings


class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(fragment_settings, container, false)
        val saveButton: Button = view.findViewById(R.id.save)
        saveButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        // Inflate the layout for this fragment
        return view
    }

}

// supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)