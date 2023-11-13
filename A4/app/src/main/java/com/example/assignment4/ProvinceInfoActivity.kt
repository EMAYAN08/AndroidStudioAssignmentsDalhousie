package com.example.assignment4

// ProvinceInfoActivity.kt
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class ProvinceInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_province_info)

        // Set up the ViewPager and TabLayout
        val viewPager: ViewPager = findViewById(R.id.viewPagerProvinceInfo)
        val tabLayout: TabLayout = findViewById(R.id.tabLayoutProvinceInfo)
        val intent = intent
        val countryName = intent.getStringExtra("key_country_name")
        if (countryName != null) {
            Log.d("provicneinfo", countryName)
        }
        // Create an adapter to manage the province info fragments
        val adapter = ProvinceInfoPagerAdapter(supportFragmentManager,countryName ?: "")
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }
}
