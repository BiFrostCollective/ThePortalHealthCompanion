package com.example.theportalexperience

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DailyIntakeActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dailyIntakeAdapter: DailyIntakeAdapter
    private val dailyNutrientsList = mutableListOf<DailyNutrient>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_intake)

        recyclerView = findViewById(R.id.recyclerViewDailyIntake)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Sample data: Add actual data dynamically after scanning food
        dailyNutrientsList.add(DailyNutrient("Protein", "50g", "You need 50g of protein daily"))
        dailyNutrientsList.add(DailyNutrient("Carbohydrates", "300g", "You need 300g of carbs daily"))
        dailyNutrientsList.add(DailyNutrient("Fat", "70g", "You need 70g of fat daily"))
        dailyNutrientsList.add(DailyNutrient("Vitamin C", "90mg", "You need 90mg of Vitamin C daily"))
        dailyNutrientsList.add(DailyNutrient("Iron", "18mg", "You need 18mg of Iron daily"))

        dailyIntakeAdapter = DailyIntakeAdapter(dailyNutrientsList)
        recyclerView.adapter = dailyIntakeAdapter
    }
}
