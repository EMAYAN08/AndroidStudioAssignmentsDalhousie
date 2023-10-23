package com.example.explorecities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class CityInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_info)

        val cityName = intent.getStringExtra("city_name") ?: ""
        val cityPopulation = intent.getStringExtra("city_population") ?: ""
        val cityLanguage = intent.getStringExtra("city_language") ?: ""
        val cityImage = intent.getIntExtra("city_image", R.drawable.default_city_image)

        val fragment = CityInfoFragment.newInstance(cityName, cityPopulation, cityLanguage, cityImage)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}
