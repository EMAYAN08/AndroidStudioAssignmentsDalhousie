package com.example.midterm2

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Data Access Object (DAO) for interacting with Dog Fact entities in the Room database.
 */
@Dao
interface DogFactDao {

    /**
     * Inserts a Dog Fact entity into the database.
     * If there is a conflict, the existing entry is replaced.
     * @param dogFact The Dog Fact entity to be inserted or replaced.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDogFact(dogFact: DogFactEntity)

    /**
     * Retrieves all Dog Fact entities from the database.
     * @return List of all Dog Fact entities in the database.
     */
    @Query("SELECT * FROM dog_facts")
    suspend fun getAllDogFacts(): List<DogFactEntity>

    /**
     * Clears all Dog Fact entities from the database.
     */
    @Query("DELETE FROM dog_facts")
    suspend fun clearDogFacts()
}
