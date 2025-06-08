package org.hasan.project

import MyAppTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.hasan.project.screen.PizzaOvenScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext

@Composable
@Preview
fun App() {
    MaterialTheme {
        KoinContext {
            MyAppTheme {

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        // You can add your TopAppBar here if needed
                        // TopAppBar(title = { Text("Pizza Oven") })
                    }
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        PizzaOvenScreen()
                    }
                }

            }
        }
    }
}