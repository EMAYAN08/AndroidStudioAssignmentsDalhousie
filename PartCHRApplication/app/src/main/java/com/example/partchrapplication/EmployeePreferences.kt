package com.example.partchrapplication

import android.content.Context
import android.content.SharedPreferences

class EmployeePreferences(context: Context) {
    // Initialize SharedPreferences for this application
    private val preferences: SharedPreferences = context.getSharedPreferences("EmployeePrefs", Context.MODE_PRIVATE)

    // Save employee preferences to SharedPreferences
    fun saveEmployeePreferences(name: String, age: Int, gender: String, dob: String, department: String) {
        val editor = preferences.edit()
        // Store employee information using appropriate keys
        editor.putString("name", name)
        editor.putInt("age", age)
        editor.putString("gender", gender)
        editor.putString("dob", dob)
        editor.putString("department", department)
        // Apply the changes
        editor.apply()
    }

    // Retrieve employee preferences from SharedPreferences
    fun getEmployeePreferences(): EmployeePreferencesModel? {
        // Retrieve stored preferences
        val name = preferences.getString("name", null)
        val age = preferences.getInt("age", -1)
        val gender = preferences.getString("gender", null)
        val dob = preferences.getString("dob", null)
        val department = preferences.getString("department", null)

        // Check if all preferences were successfully retrieved
        return if (name != null && age != -1 && gender != null && dob != null && department != null) {
            // Return as a EmployeePreferencesModel
            EmployeePreferencesModel(name, age, gender, dob, department)
        } else {
            // Return null if any preferences are missing
            null
        }
    }
}
