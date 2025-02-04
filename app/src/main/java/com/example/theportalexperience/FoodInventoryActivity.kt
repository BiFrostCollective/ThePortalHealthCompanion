package com.example.theportalexperience

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FoodInventoryActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FoodInventoryAdapter
    private val foodList = mutableListOf(
        FoodItem("Apple", "52 cal", "Vitamin C: 14% daily value"),
        FoodItem("Banana", "96 cal", "Potassium: 12% daily value"),
        FoodItem("Chicken Breast", "165 cal", "Protein: 30% daily value")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_inventory)

        recyclerView = findViewById(R.id.rvFoodList)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = FoodInventoryAdapter(foodList)
        recyclerView.adapter = adapter

        // Navigate to Scanner when button is clicked
        val scanButton: Button = findViewById(R.id.btnScanNewFood)
        scanButton.setOnClickListener {
            val intent = Intent(this, FoodScannerActivity::class.java)
            startActivity(intent)
        }
    }
}


