package com.example.theportalexperience

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DailyIntakeAdapter(private val dailyIntakeList: List<DailyNutrient>) :
    RecyclerView.Adapter<DailyIntakeAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nutrientName: TextView = itemView.findViewById(R.id.tvNutrientName)
        val requiredAmount: TextView = itemView.findViewById(R.id.tvRequiredAmount)
        val description: TextView = itemView.findViewById(R.id.tvNutrientDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_daily_nutrient, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val nutrient = dailyIntakeList[position]
        holder.nutrientName.text = nutrient.name
        holder.requiredAmount.text = nutrient.requiredAmount
        holder.description.text = nutrient.description
    }

    override fun getItemCount(): Int {
        return dailyIntakeList.size
    }
}
