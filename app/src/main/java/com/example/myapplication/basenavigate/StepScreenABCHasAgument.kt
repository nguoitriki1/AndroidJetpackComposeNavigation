package com.example.myapplication.basenavigate

import android.os.Bundle
import android.util.Log
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.basenavigate.ui.theme.MyApplicationTheme
import java.io.File

class StepScreenABCHasAgument : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    DefaultPreview4()
                }
            }
        }
    }
}

@Composable
fun DefaultPreview4() {
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
                    val data = "du lieu chuyen tu screen1 -> screen2"
                    val convertDataLink = if (data.isBlank()) {
                        null
                    } else {
                        File.separator + data
                    }
                    navController.navigate("screen2$convertDataLink")
                }) {
                    Text(text = "Screen1", color = Color.White)
                }
            }
            composable(
                "screen2/{data}",
                arguments = listOf(navArgument("data") { type = NavType.StringType })
            ) {
                val args = it.arguments?.getString("data", "nothing")
                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp), onClick = {
                    val dataSendToScreen3 = "dataSendFromScreen2ToScreen3"
                    navController.navigate("screen3?user=$dataSendToScreen3")
                }) {
                    Text(text = "Screen2", color = Color.White)
                }
            }

            composable("screen3?user={user}", arguments = listOf(navArgument("user") {
                nullable = true
            })) {
                val dataSendFromScreen2 = it.arguments?.getString("user", null)
                Text(text = "screen3", color = Color.Black)
            }

        })
}