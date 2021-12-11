package com.example.myapplication.navigatevn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme

enum class VietNamRoute{
    HaNoi,HaNam
}

enum class HaNoiRoute{
    TuLiem,ThanhXuan,CauGiay
}

enum class HaNamRoute{
    KimBang,LyNhan,PhuLy
}

class NavigateVietNamExample : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                DefaultPreview()
            }
        }
    }
}

@Composable
fun DefaultPreview() {
    val navController = rememberNavController()
    HostVietNam(navController = navController)
}