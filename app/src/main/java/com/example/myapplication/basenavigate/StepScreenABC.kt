package com.example.myapplication.basenavigate

import android.app.ActivityOptions
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityOptionsCompat
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.basenavigate.ui.theme.MyApplicationTheme







class StepScreenABC : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                DefaultPreview3()
            }
        }
    }
}

@Composable
fun DefaultPreview3() {

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
                    navController.navigate(route = "screen2")
                }) {
                    Text(text = "Screen1", color = Color.White)
                }
            }
            composable("screen2") {
                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp), onClick = {
                    navController.navigate("screen3")
                }) {
                    Text(text = "Screen2", color = Color.White)
                }
            }
            composable("screen3") {
                Text(text = "Screen3", color = Color.Black)
            }
        })
}