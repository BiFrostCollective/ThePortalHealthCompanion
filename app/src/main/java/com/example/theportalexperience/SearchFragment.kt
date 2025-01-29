package com.example.theportalexperience

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.fragment.app.Fragment

class SearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_search, container, false)

        val searchEditText: EditText = view.findViewById(R.id.searchEditText)
        val searchButton: Button = view.findViewById(R.id.searchButton)
        val searchResultsListView: ListView = view.findViewById(R.id.searchResultsListView)

        // Mock data for search results
        val mockData = listOf("Recipe 1", "Recipe 2", "Recipe 3", "Diet Plan A", "Diet Plan B")

        searchButton.setOnClickListener {
            val searchQuery = searchEditText.text.toString().toLowerCase()
            val filteredResults = mockData.filter { it.toLowerCase().contains(searchQuery) }
            val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, filteredResults)
            searchResultsListView.adapter = adapter
        }

        return view
    }

    companion object {
        fun newInstance() = SearchFragment()
    }
}