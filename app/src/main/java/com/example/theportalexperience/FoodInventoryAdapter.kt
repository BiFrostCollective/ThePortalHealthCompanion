package com.example.theportalexperience

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// REMOVE THE DUPLICATE FoodItem DECLARATION
// `FoodItem` is already defined in `FoodItem.kt`, so just import it.

class FoodInventoryAdapter(private val foodList: List<FoodItem>) :
    RecyclerView.Adapter<FoodInventoryAdapter.FoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.food_item, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val foodItem = foodList[position]
        holder.foodName.text = foodItem.name
        holder.foodCalories.text = foodItem.calories
        holder.foodNutrients.text = foodItem.nutrients
    }

    override fun getItemCount() = foodList.size

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foodName: TextView = itemView.findViewById(R.id.tvFoodName)
        val foodCalories: TextView = itemView.findViewById(R.id.tvFoodCalories)
        val foodNutrients: TextView = itemView.findViewById(R.id.tvFoodNutrients)
    }
}
