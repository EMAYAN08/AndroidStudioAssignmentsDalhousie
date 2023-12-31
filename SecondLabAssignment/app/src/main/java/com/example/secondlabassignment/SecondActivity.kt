package com.example.secondlabassignment

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.secondlabassignment.ui.theme.SecondLabAssignmentTheme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
                        // Button to return to the LoginActivity
                        Button(
                            onClick = {
                                finish() // Return to LoginActivity
                            },
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text("Return to Login")
                        }
                        // Button to navigate to the WebActivity
                        Button(
                            onClick = {
                                val intent = Intent(this@SecondActivity, WebActivity::class.java)
                                startActivity(intent)
                            },
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text("Navigate to Web")
                        }
                    }
                }
            }
        }
    }
}