package com.example.myapplication.navigatevn

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.myapplication.navigatevn.hanam.KimBangScreen
import com.example.myapplication.navigatevn.hanam.LyNhanScreen
import com.example.myapplication.navigatevn.hanam.PhuLyScreen
import com.example.myapplication.navigatevn.hanoi.CauGiayScreen
import com.example.myapplication.navigatevn.hanoi.ThanhXuanScreen
import com.example.myapplication.navigatevn.hanoi.TuLiemScreen


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
                    CauGiayScreen(
                        navController = navController,
                        routeName = HaNoiRoute.CauGiay.name,
                        navigateRouteName = HaNoiRoute.ThanhXuan.name
                    )
                }

                composable(HaNoiRoute.ThanhXuan.name) {
                    ThanhXuanScreen(
                        navController = navController,
                        routeName = HaNoiRoute.ThanhXuan.name,
                        navigateRouteName = HaNoiRoute.TuLiem.name
                    )
                }

                composable(HaNoiRoute.TuLiem.name) {
                    TuLiemScreen(
                        navController = navController,
                        routeName = HaNoiRoute.TuLiem.name,
                        navigateRouteName = VietNamRoute.HaNam.name
                    )
                }
            }

            /////////////////////////Ha nam////////////////////////

            navigation(HaNamRoute.KimBang.name, VietNamRoute.HaNam.name) {
                composable(HaNamRoute.KimBang.name) {
                    KimBangScreen(
                        navController = navController,
                        routeName = HaNamRoute.KimBang.name,
                        navigateRouteName = HaNamRoute.LyNhan.name
                    )
                }
                composable(HaNamRoute.LyNhan.name) {
                    LyNhanScreen(
                        navController = navController,
                        routeName = HaNamRoute.LyNhan.name,
                        navigateRouteName = HaNamRoute.PhuLy.name
                    )
                }
                composable(HaNamRoute.PhuLy.name) {
                    PhuLyScreen(
                        context = context,
                        navController = navController,
                        routeName = HaNamRoute.PhuLy.name,
                        navigateRouteName = null
                    )
                }
            }
        })

}