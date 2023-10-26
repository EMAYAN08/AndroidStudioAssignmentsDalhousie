package com.example.partchrapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    // UI elements
    private lateinit var editTextName: EditText
    private lateinit var editTextAge: EditText
    private lateinit var editTextGender: EditText
    private lateinit var editTextDOB: EditText
    private lateinit var editTextDepartment: EditText
    private lateinit var saveButton: Button

    // SharedPreferences helper
    private lateinit var employeePreferences: EmployeePreferences

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI elements
        editTextName = findViewById(R.id.editTextName)
        editTextAge = findViewById(R.id.editTextAge)
        editTextGender = findViewById(R.id.editTextGender)
        editTextDOB = findViewById(R.id.editTextDOB)
        editTextDepartment = findViewById(R.id.editTextDepartment)
        saveButton = findViewById(R.id.buttonSave)

        // Initialize SharedPreferences helper
        employeePreferences = EmployeePreferences(this)

        // Load preferences if available
        loadPreferences()

        // Set click listener for save button
        saveButton.setOnClickListener {
            savePreferences()
        }
    }

    // Load preferences from SharedPreferences and populate UI fields
    private fun loadPreferences() {
        val preferences = employeePreferences.getEmployeePreferences()
        if (preferences != null) {
            editTextName.setText(preferences.name)
            editTextAge.setText(preferences.age.toString())
            editTextGender.setText(preferences.gender)
            editTextDOB.setText(preferences.dob)
            editTextDepartment.setText(preferences.department)
        }
    }

    // Save user input to SharedPreferences
    private fun savePreferences() {
        val name = editTextName.text.toString()
        val age = editTextAge.text.toString().toIntOrNull()
        val gender = editTextGender.text.toString()
        val dob = editTextDOB.text.toString()
        val department = editTextDepartment.text.toString()

        // Check if all fields are filled
        if (name.isNotEmpty() && age != null && gender.isNotEmpty() && dob.isNotEmpty() && department.isNotEmpty()) {
            // Save preferences if input is valid
            employeePreferences.saveEmployeePreferences(name, age, gender, dob, department)
            Toast.makeText(this, "Preferences saved", Toast.LENGTH_SHORT).show()
        } else {
            // Display error message if any field is empty
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
        }
    }
}
