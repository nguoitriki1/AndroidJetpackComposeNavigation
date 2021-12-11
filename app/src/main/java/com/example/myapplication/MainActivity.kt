package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.basenavigate.StepScreenABC
import com.example.myapplication.basenavigate.StepScreenABCBackToA
import com.example.myapplication.basenavigate.StepScreenABCHasAgument
import com.example.myapplication.navigatevn.NavigateVietNamExample
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity(), OnExampleClick {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                DefaultPreview2(this)
            }
        }
    }

    override fun onClickStepABC() {
        startActivity(Intent(this@MainActivity,StepScreenABC::class.java))
    }

    override fun onClickStepABCHasArgument() {
        startActivity(Intent(this@MainActivity,StepScreenABCHasAgument::class.java))
    }

    override fun onClickStepABCBackToA() {
        startActivity(Intent(this@MainActivity,StepScreenABCBackToA::class.java))
    }

    override fun onClickNestedNavigation() {
        startActivity(Intent(this@MainActivity,NavigateVietNamExample::class.java))
    }
}

interface OnExampleClick{
    fun onClickStepABC()
    fun onClickStepABCHasArgument()
    fun onClickStepABCBackToA()
    fun onClickNestedNavigation()
}

@Composable
fun DefaultPreview2(onClickAction : OnExampleClick) {
    MyApplicationTheme {
        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),Arrangement.Center,Alignment.CenterHorizontally) {
            Text(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),text = "A -> B -> C (No data)",color = Color.Red)
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),onClick = {
                onClickAction.onClickStepABC()
            }) {
                Text(text = "Example")
            }

            Text(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),text = "A -> B -> C (Has data)",color = Color.Red)
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),onClick = {
                onClickAction.onClickStepABCHasArgument()
            }) {
                Text(text = "Example")
            }

            Text(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),text = "A -> B -> C backTo A",color = Color.Red)
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),onClick = {
                onClickAction.onClickStepABCBackToA()
            }) {
                Text(text = "Example")
            }

            Text(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),text = "A -> B -> C backTo A (has Data)",color = Color.Red)
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),onClick = {
                onClickAction.onClickStepABCBackToA()
            }) {
                Text(text = "Example")
            }

            Text(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),text = "A -> B -> C backTo A (has Data)",color = Color.Red)
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),onClick = {
                onClickAction.onClickStepABCBackToA()
            }) {
                Text(text = "Example")
            }

            Text(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),text = "Nested Navigation Graphs in Jetpack Compose ",color = Color.Red)
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),onClick = {
                onClickAction.onClickNestedNavigation()
            }) {
                Text(text = "Example Nested Navigation")
            }
        }
    }
}