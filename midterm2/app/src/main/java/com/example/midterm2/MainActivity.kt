package com.example.midterm2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Socket

class MainActivity : ComponentActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dogFactAdapter: DogFactAdapter
    private lateinit var dogFactDao: DogFactDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize RecyclerView and set its layout manager
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize DogFactAdapter with an empty list and set it to RecyclerView
        dogFactAdapter = DogFactAdapter(emptyList())
        recyclerView.adapter = dogFactAdapter

        // Get an instance of the DogFactDao from the database
        val db = AppDatabase.getDatabase(this)
        dogFactDao = db.dogFactDao()

        // Use CoroutineScope to perform asynchronous operations
        CoroutineScope(Dispatchers.IO).launch {
            try {
                // Check if the device has internet connectivity
                val isConnected = hasInternetConnection()

                var dogFactList = listOf<DogFactEntity>()

                // If there is no internet connection, retrieve data from the local database
                if (!isConnected) {
                    dogFactList = dogFactDao.getAllDogFacts()
                } else {
                    // Clear the local database before fetching and inserting new data
                    dogFactDao.clearDogFacts()

                    // Fetch a new DogFact from the API
                    val dogFact = RetrofitClient.service.getDogFact()

                    // Create a new DogFactEntity and insert it into the local database
                    val newDogFactEntity =
                        DogFactEntity(facts = dogFact.facts.joinToString("\n\n"), success = dogFact.success)
                    dogFactDao.insertDogFact(newDogFactEntity)
                    dogFactList = listOf(newDogFactEntity)
                }

                // Create a list of formatted strings for displaying in the UI
                val finalString =
                    dogFactList.map { "Fact:\t" + it.facts + "\n\n length:\t" + it.success }

                // Switch to the Main dispatcher to update the UI
                withContext(Dispatchers.Main) {
                    // Update the adapter data with the final list of strings
                    dogFactAdapter.setData(finalString)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    // Check if the device has internet connection by attempting to create a socket connection
    private fun hasInternetConnection(): Boolean {
        return try {
            val timeoutMs = 1500
            val socket = Socket()
            val socketAddress = InetSocketAddress("8.8.8.8", 53)

            // Attempt to connect to a known server (Google's public DNS server)
            socket.connect(socketAddress, timeoutMs)
            socket.close()

            true
        } catch (e: IOException) {
            // An IOException indicates that there is no internet connection
            e.printStackTrace()
            false
        }
    }
}
