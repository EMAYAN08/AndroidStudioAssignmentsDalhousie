package com.example.explorecities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ContinentActivity : AppCompatActivity() {
    private lateinit var cityRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_continent)

        val selectedContinent = intent.getStringExtra("continent") ?: ""

        cityRecyclerView = findViewById(R.id.cityRecyclerView)
        cityRecyclerView.layoutManager = LinearLayoutManager(this)

        
        val cities = mutableListOf(
            City("Paris", R.drawable.default_city_image, "77120456", "Marati"),
            City("Chennai", R.drawable.default_city_image, "Population 2", "Language 2"),
        )

        val adapter = CityAdapter(cities) { city ->
            val intent = Intent(this, CityInfoActivity::class.java).apply {
                putExtra("city_name", city.name)
                putExtra("city_population", city.population)
                putExtra("city_language", city.language)
                putExtra("city_image", city.imageResource)
            }
            startActivity(intent)
        }

        cityRecyclerView.adapter = adapter
    }
}
