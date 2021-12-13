package com.example.myapplication.navigatevn.hanam

import android.content.Context
import android.widget.Toast
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
import com.example.myapplication.navigatevn.HaNamRoute


@Composable()
fun PhuLyScreen(context : Context, navController: NavController, routeName : String, navigateRouteName : String?){
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.Yellow), Arrangement.Center
    ) {
        Text(text = HaNamRoute.PhuLy.name)
        Button(onClick = {
            Toast.makeText(context, "End Route", Toast.LENGTH_SHORT).show()
        }) {

        }
    }
}