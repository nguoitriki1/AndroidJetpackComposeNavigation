package com.example.myapplication.navigatevn

import android.util.Log
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
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import com.example.myapplication.navigatevn.hanam.RouteHaNamScreen
import com.example.myapplication.navigatevn.hanoi.RouteHaNoiScreen


@Composable
fun HostVietNam(navController: NavHostController) {
    val routeVietNam = "VietNam"
    val context = LocalContext.current
    NavHost(
        navController,
        route = routeVietNam,
        startDestination = VietNamRoute.HaNoi.name,
        builder = {
            navigation(HaNoiRoute.CauGiay.name, VietNamRoute.HaNoi.name) {
                composable(HaNoiRoute.CauGiay.name) {
                    RouteHaNoiScreen(
                        navController = navController,
                        routeName = HaNoiRoute.CauGiay.name,
                        navigateRouteName = HaNoiRoute.ThanhXuan.name
                    )
                }

                composable(HaNoiRoute.ThanhXuan.name) {
                    RouteHaNoiScreen(
                        navController = navController,
                        routeName = HaNoiRoute.ThanhXuan.name,
                        navigateRouteName = HaNoiRoute.TuLiem.name
                    )
                }

                composable(HaNoiRoute.TuLiem.name) {
                    RouteHaNoiScreen(
                        navController = navController,
                        routeName = HaNoiRoute.TuLiem.name,
                        navigateRouteName = VietNamRoute.HaNam.name
                    )
                }
            }

            /////////////////////////Ha nam////////////////////////

            navigation(HaNamRoute.KimBang.name, VietNamRoute.HaNam.name) {
                composable(HaNamRoute.KimBang.name) {
                    RouteHaNamScreen(
                        navController = navController,
                        routeName = HaNamRoute.KimBang.name,
                        navigateRouteName = HaNamRoute.LyNhan.name
                    )
                }
                composable(HaNamRoute.LyNhan.name) {
                    RouteHaNamScreen(
                        navController = navController,
                        routeName = HaNamRoute.LyNhan.name,
                        navigateRouteName = HaNamRoute.PhuLy.name
                    )
                }
                composable(HaNamRoute.PhuLy.name) {
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
            }
        })

}