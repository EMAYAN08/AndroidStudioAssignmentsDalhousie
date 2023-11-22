package com.example.midterm2

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entity class representing Dog Fact data stored in the Room database.
 * @param facts The actual Dog Fact string.
 * @param success The boolean value indicating the success status of the Dog Fact retrieval.
 */
@Entity(tableName = "dog_facts")
data class DogFactEntity(
    @PrimaryKey val facts: String,
    val success: Boolean
)