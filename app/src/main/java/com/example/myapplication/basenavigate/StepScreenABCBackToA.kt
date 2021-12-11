package com.example.myapplication.basenavigate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.basenavigate.ui.theme.MyApplicationTheme

class StepScreenABCBackToA : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
               DefaultPreview5()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "screen1",
        route = null,
        builder = {
            composable("screen1") {
                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp), onClick = {
                    navController.navigate("screen2")
                }) {

                }
            }
            composable("screen2") {
                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp), onClick = {
                    navController.navigate("screen3")
                }) {

                }
            }
            composable("screen3") {
                Text(text = "Screen3")
            }
        })
}