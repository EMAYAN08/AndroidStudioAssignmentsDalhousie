package com.example.secondlabassignment

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.ui.Alignment
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.secondlabassignment.ui.theme.SecondLabAssignmentTheme

class LoginActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Define mutable state variables for username and password
            var username by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }

            setContent {
                SecondLabAssignmentTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            // Input field for entering the username
                            OutlinedTextField(
                                value = username,
                                onValueChange = { username = it },
                                label = { Text("Username") },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                            )
                            // Input field for entering the password
                            OutlinedTextField(
                                value = password,
                                onValueChange = { password = it },
                                label = { Text("Password") },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                            )
                            // Button to perform login
                            Button(
                                onClick = {
                                    if (username == "Emayan" && password == "Vadivel") {
                                        // If username and password match, navigate to SecondActivity
                                        val intent = Intent(this@LoginActivity, SecondActivity::class.java)
                                        startActivity(intent)
                                    } else {
                                        // Handle authentication failure
                                        println("Error during authentication")
                                    }
                                },
                                modifier = Modifier.padding(16.dp)
                            ) {
                                Text("Login")
                            }
                        }
                    }
                }
            }
        }
    }
}