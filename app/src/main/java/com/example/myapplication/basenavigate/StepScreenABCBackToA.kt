package com.example.myapplication.basenavigate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
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
            composable(
                "screen1"
            ) {
                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp), onClick = {
                    navController.navigate("screen2")
                }) {
                    Text(text = "Screen1", color = Color.White)
                }
            }
            composable("screen2") {
                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp), onClick = {
                    navController.navigate("screen3")
//                    {
//                        this.popUpTo("screen1") {
//                            this.saveState = true
//                            this.inclusive = false
//                        }
//                        this.anim {
//
//                        }
//                    }
                }) {
                    Text(text = "Screen2", color = Color.White)
                }
            }
            composable("screen3") {
                BackHandler(true) {
                    navController.popBackStack("screen1", false, true)
                }
                Text(text = "Screen3", color = Color.Black)
            }
        })
}