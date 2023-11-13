package com.example.assignment4

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log

import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), CountrySelectionFragment.CountrySelectionListener,
    NavigationView.OnNavigationItemSelectedListener {

    private lateinit var countrySelectionFragment: CountrySelectionFragment
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var yourButton: Button
    var globalString: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            countrySelectionFragment = CountrySelectionFragment()
            countrySelectionFragment.setCountrySelectionListener(this)

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, countrySelectionFragment)
                .commit()
        }

        // Initialize the Toolbar
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Initialize the DrawerLayout
        drawerLayout = findViewById(R.id.drawerLayout)
//        yourButton = findViewById<Button>(R.id.btnSelectCountry)

        // Set up the ActionBarDrawerToggle to enable the hamburger icon for the NavigationDrawer
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Set up the NavigationView
        val navigationView: NavigationView = findViewById(R.id.navigationView)
        navigationView.setNavigationItemSelectedListener(this)

        // Display the CountrySelectionFragment initially

    }

    override fun onCountrySelected(country: Country) {
        // Handle the selected country
        // You can update UI or perform any other actions here
        // For now, simply log the selected country
        println("Selected Country: ${country.name}")
        globalString = country.name
        // Display the selected country's image in the background
        // Replace R.id.backgroundImage with the actual ID of your ImageView
        findViewById<ImageView>(R.id.backgroundImage).setImageResource(country.imageResourceId)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        Log.d("MainActivity", "onNavigationItemSelected called") // Add this line

        when (item.itemId) {
            R.id.navProvinceInfo -> {
                // Handle "Province Info" selected
//                replaceFragment(ProvinceInfoFragment.newInstance("Your Province Name"))


                val intent = Intent(this, ProvinceInfoActivity::class.java)
                intent.putExtra("key_country_name", globalString)
                startActivity(intent)
                Log.d("MainActivity", "Province Info clicked")
            }
            R.id.navCities -> {
                // Handle "Cities" selected
//                replaceFragment(CitiesFragment())
                Log.d("MainActivity", "Cities clicked")
                val intent = Intent(this, CitiesActivity::class.java)
                intent.putExtra("key_country_name", globalString)
                startActivity(intent)
            }
        }

        // Close the DrawerLayout after an item is selected
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    // Override onBackPressed to close the DrawerLayout when the back button is pressed
//    override fun onBackPressed() {
//        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
//            drawerLayout.closeDrawer(GravityCompat.START)
//        } else {
//            super.onBackPressed()
//        }
   //}
}

