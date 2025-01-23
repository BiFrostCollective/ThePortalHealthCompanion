package com.example.theportalexperience

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ManualEntryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manual_entry)

        // References to UI elements
        val barcodeInput = findViewById<EditText>(R.id.etBarcodeInput)
        val saveButton = findViewById<Button>(R.id.btnSave)
        val foodImage = findViewById<ImageView>(R.id.ivFoodImage)

        // Handle save button click
        saveButton.setOnClickListener {
            val barcodeValue = barcodeInput.text.toString()

            if (barcodeValue.isNotEmpty()) {
                // For now, just display a message
                Toast.makeText(
                    this,
                    "Saved barcode: $barcodeValue",
                    Toast.LENGTH_SHORT
                ).show()

                // In a real app, update the image (foodImage) and save the entry to a database
                foodImage.setImageResource(android.R.drawable.ic_menu_gallery) // Example placeholder image
            } else {
                Toast.makeText(
                    this,
                    "Please enter a barcode!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
