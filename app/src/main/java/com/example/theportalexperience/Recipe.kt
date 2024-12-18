package com.example.theportalexperience

// This class represents a single Recipe item, containing properties like 'name'.
// Use this class to store data for each individual recipe that will be displayed in the RecyclerView.
// This class serves as the data model for the RecyclerView adapter to bind the information to the UI.
class Recipe(
    val name: String, // The name of the recipe, which will be displayed in the RecyclerView.
    // You can add more properties here if needed, such as a description, image URL, or preparation time.
)