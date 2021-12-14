package com.example.myapplication.basenavigate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.basenavigate.ui.theme.MyApplicationTheme

class TwoFrameExample : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                DefaultPreview8()
            }
        }
    }
}

@Composable
fun DefaultPreview8() {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f)
            .background(Color.Yellow)
            .padding(16.dp)){
            HostTopScreen()
        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Blue)
            .padding(16.dp)){
            HostBottomScreen()
        }
    }
}

@Composable
fun HostTopScreen(){
    val navController = rememberNavController()
    NavHost(navController = navController,modifier = Modifier.fillMaxSize(), startDestination = "screen1", builder = {
        composable("screen1") {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.Yellow), Alignment.Center) {
                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp), onClick = {
                    navController.navigate(route = "screen2")
                }) {
                    Text(text = "Screen1", color = Color.White)
                }
            }
        }
        composable("screen2") {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.Green), Alignment.Center) {
                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp), onClick = {
                    navController.navigate("screen3")
                }) {
                    Text(text = "Screen2", color = Color.White)
                }
            }
        }
        composable("screen3") {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.Blue), Alignment.Center) {
                Text(text = "Screen3", color = Color.Black)
            }
        }
    })
}

@Composable
fun HostBottomScreen(){
    val navController = rememberNavController()
    NavHost(navController = navController, modifier = Modifier.fillMaxSize(), startDestination = "screen4", builder = {
        composable("screen4") {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.Red), Alignment.Center) {
                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp), onClick = {
                    navController.navigate(route = "screen5")
                }) {
                    Text(text = "screen4", color = Color.White)
                }
            }
        }
        composable("screen5") {
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp), onClick = {
                navController.navigate("screen6")
            }) {
                Text(text = "screen5", color = Color.White)
            }
        }
        composable("screen6") {
            Text(text = "screen6", color = Color.Black)
        }
    })
}