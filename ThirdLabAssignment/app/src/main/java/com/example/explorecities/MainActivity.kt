package com.example.explorecities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var continentListView: ListView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        continentListView = findViewById(R.id.continentListView)

        // Sample data for continents
        val continents = arrayOf("Asia", "Europe", "North America", "South America", "Africa", "Australia")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, continents)
        continentListView.adapter = adapter

        continentListView.setOnItemClickListener { _, _, position, _ ->
            val selectedContinent = continents[position]

            val intent = Intent(this, ContinentActivity::class.java).apply {
                putExtra("continent", selectedContinent)
            }
            startActivity(intent)
        }
    }
}
