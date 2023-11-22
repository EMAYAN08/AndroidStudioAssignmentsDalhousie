package com.example.midterm2

/**
 * Data class representing DogFact entity.
 * @property facts List of strings containing dog facts.
 * @property success Boolean indicating the success status of the API response.
 */
data class DogFact(
    val facts: List<String>,
    val success: Boolean
)
