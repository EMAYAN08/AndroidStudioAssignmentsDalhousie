package com.example.assignment4

// CitiesActivity.kt
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class CitiesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cities)

        // Set up the ViewPager and TabLayout
        val viewPager: ViewPager = findViewById(R.id.viewPagerCities)
        val tabLayout: TabLayout = findViewById(R.id.tabLayoutCities)
        val countryName = intent.getStringExtra("key_country_name")
        if (countryName != null) {
            Log.d("provicneinfo", countryName)
        }
        // Create an adapter to manage the city fragments
        val adapter = CitiesPagerAdapter(supportFragmentManager,countryName ?: "")

        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }
}
