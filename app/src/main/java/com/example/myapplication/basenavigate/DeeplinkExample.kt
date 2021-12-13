package com.example.myapplication.basenavigate

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.example.myapplication.basenavigate.ui.theme.MyApplicationTheme

class DeeplinkExample : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                DefaultPreview6()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview6() {
    val navController = rememberNavController()
    val rootUri = "https://www.abc.com"
    NavHost(
        navController = navController,
        startDestination = "screen1?content={content}",
        route = "host_deep_link",
        builder = {

            val screen1DeepLinks = listOf(
                navDeepLink {
                    uriPattern = "$rootUri/screen1/{content}"
                },
            )

            val screen2DeepLinks = listOf(
                navDeepLink {
                    uriPattern = "$rootUri/screen2"
                },
            )


            composable(
                "screen1?content={content}",
                deepLinks = screen1DeepLinks,
                arguments = listOf(
                    navArgument("content") { type = NavType.StringType }
                )
            ) {
                val data = it.arguments?.getString("content", "nothing")
                Log.d("abc", "composable data : $data")
                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp), onClick = {
                }) {
                    Text(text = "Screen1", color = Color.White)
                }
            }

            composable("screen2", deepLinks = screen2DeepLinks) {
                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp), onClick = {
                    navController.navigate("screen3")
                }) {
                    Text(text = "Screen2", color = Color.White)
                }
            }
        })
}