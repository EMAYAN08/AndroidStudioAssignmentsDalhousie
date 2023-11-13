package com.example.assignment4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment

class CountrySelectionFragment : Fragment() {

    interface CountrySelectionListener {
        fun onCountrySelected(country: Country)
    }

    private lateinit var listener: CountrySelectionListener
    private lateinit var countrySpinner: Spinner
    private val countryList = listOf(
        Country("canada", R.drawable.country1),
        Country("usa", R.drawable.country2),
        // Add more countries as needed
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_country_selection, container, false)

        countrySpinner = view.findViewById(R.id.countrySpinner)

        // Create an ArrayAdapter using the string array and a default spinner layout
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            countryList.map { it.name }
        )

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Apply the adapter to the spinner
        countrySpinner.adapter = adapter

        // Set up the spinner item selection listener
        countrySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedCountry = countryList[position]
                listener.onCountrySelected(selectedCountry)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle case when nothing is selected
            }
        }

        return view
    }

    fun setCountrySelectionListener(listener: CountrySelectionListener) {
        this.listener = listener
    }
}

