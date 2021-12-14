package com.example.myapplication.basenavigate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.basenavigate.ui.theme.MyApplicationTheme
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.bottomSheet
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import java.util.*

class BottomSheetNavSample : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                BottomSheetNavDemo()
            }
        }
    }
}

private object Destinations {
    const val Home = "HOME"
    const val Feed = "FEED"
    const val Sheet = "SHEET"
}

@ExperimentalMaterialApi
@OptIn(ExperimentalMaterialNavigationApi::class)
@Composable
fun BottomSheetNavDemo() {
    MaterialTheme {
        val bottomSheetNavigator = rememberBottomSheetNavigator()
        val navController = rememberNavController(bottomSheetNavigator)
        com.google.accompanist.navigation.material.ModalBottomSheetLayout(bottomSheetNavigator = bottomSheetNavigator) {
            NavHost(navController, Destinations.Home) {
                composable(Destinations.Home) {
                    HomeScreen(
                        showSheet = {
                            navController.navigate(Destinations.Sheet + "?arg=From Home Screen")
                        },
                        showFeed = { navController.navigate(Destinations.Feed) }
                    )
                }
                composable(Destinations.Feed) { Text("Feed!") }
                bottomSheet(Destinations.Sheet + "?arg={arg}") { backstackEntry ->
                    val arg = backstackEntry.arguments?.getString("arg") ?: "Missing argument :("
                    BottomSheet(
                        showFeed = { navController.navigate(Destinations.Feed) },
                        showAnotherSheet = {
                            navController.navigate(Destinations.Sheet + "?arg=${UUID.randomUUID()}")
                        },
                        arg = arg
                    )
                }
            }
        }
    }
}

@Composable
private fun HomeScreen(showSheet: () -> Unit, showFeed: () -> Unit) {
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Body")
        Button(onClick = showSheet) {
            Text("Show sheet!")
        }
        Button(onClick = showFeed) {
            Text("Navigate to Feed")
        }
    }
}

@Composable
private fun BottomSheet(showFeed: () -> Unit, showAnotherSheet: () -> Unit, arg: String) {
    Text("Sheet with arg: $arg")
    Button(onClick = showFeed) {
        Text("Click me to navigate!")
    }
    Button(onClick = showAnotherSheet) {
        Text("Click me to show another sheet!")
    }
}