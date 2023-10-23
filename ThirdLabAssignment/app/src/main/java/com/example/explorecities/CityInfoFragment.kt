package com.example.explorecities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class CityInfoFragment : Fragment() {
    private lateinit var cityNameTextView: TextView
    private lateinit var populationTextView: TextView
    private lateinit var languageTextView: TextView
    private lateinit var cityImageView: ImageView

    private var cityName: String = ""
    private var cityPopulation: String = ""
    private var cityLanguage: String = ""
    private var cityImageResource: Int = R.drawable.default_city_image

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            cityName = it.getString("city_name", "")
            cityPopulation = it.getString("city_population", "")
            cityLanguage = it.getString("city_language", "")
            cityImageResource = it.getInt("city_image", R.drawable.default_city_image)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_city_info, container, false)

        cityNameTextView = view.findViewById(R.id.cityNameTextView)
        populationTextView = view.findViewById(R.id.populationTextView)
        languageTextView = view.findViewById(R.id.languageTextView)
        cityImageView = view.findViewById(R.id.cityImageView)

        cityNameTextView.text = cityName
        populationTextView.text = cityPopulation
        languageTextView.text = cityLanguage
        cityImageView.setImageResource(cityImageResource)

        return view
    }

    companion object {
        fun newInstance(name: String, population: String, language: String, imageResource: Int) =
            CityInfoFragment().apply {
                arguments = Bundle().apply {
                    putString("city_name", name)
                    putString("city_population", population)
                    putString("city_language", language)
                    putInt("city_image", imageResource)
                }
            }
    }
}
