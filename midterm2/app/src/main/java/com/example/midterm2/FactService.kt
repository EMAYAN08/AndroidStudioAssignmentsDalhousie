package com.example.midterm2

import retrofit2.http.GET

/**
 * Retrofit service interface for fetching Dog Facts.
 */
interface FactService {

    /**
     * Retrieves Dog Facts from the specified endpoint.
     * @return A DogFact object representing the fetched data.
     */
    @GET("/api/facts?number=5")
    suspend fun getDogFact(): DogFact // DogFact is a data class for the JSON structure
}
