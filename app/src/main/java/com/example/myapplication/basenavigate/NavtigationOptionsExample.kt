package com.example.myapplication.basenavigate

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.app.ActivityOptionsCompat
import androidx.navigation.ActivityNavigatorExtras
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import androidx.transition.Fade
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

class NavtigationOptionsExample : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                DefaultPreview7(this)
            }
        }
    }
}

@Composable
fun DefaultPreview7(activity: ComponentActivity) {

    val navController = rememberNavController()
    val context = LocalContext.current

    val navOptions = navOptions {
        this.anim {
            this.enter = R.anim.left_slide_animation
            this.exit = R.anim.right_slide_animation
            this.popEnter = R.anim.left_slide_animation
            this.popExit = R.anim.right_slide_animation
        }
    }

    val options =
        ActivityOptionsCompat.makeSceneTransitionAnimation(activity, View(context), "profile")
    val extras = ActivityNavigatorExtras(
        options
    )

    NavHost(
        navController = navController,
        startDestination = "screen1",
        route = null,
        builder = {
            composable("screen1") {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Yellow)
                        .padding(32.dp),
                    Arrangement.Center,
                    Alignment.CenterHorizontally
                ) {
                    Button(modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp), onClick = {
                        navController.navigate(
                            "screen2",
                            navOptions = navOptions,
                            navigatorExtras = extras
                        )
                    }) {
                        Text(text = "Screen1", color = Color.White)
                    }
                }

            }
            composable("screen2") {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Green)
                        .padding(32.dp),
                    Arrangement.Center,
                    Alignment.CenterHorizontally
                ) {
                    Button(modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp), onClick = {
                    }) {
                        Text(text = "Screen2", color = Color.White)
                    }
                }

            }
        })
}