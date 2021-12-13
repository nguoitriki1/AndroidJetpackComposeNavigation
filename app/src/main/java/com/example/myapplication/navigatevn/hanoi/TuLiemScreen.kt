package com.example.myapplication.navigatevn.hanoi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController


@Composable()
fun TuLiemScreen(navController: NavController, routeName : String, navigateRouteName : String){
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.Yellow),Arrangement.Center) {
        Text(text = routeName)
        Button(onClick = {
            navController.navigate(navigateRouteName)
        }) {

        }
    }
}