package com.example.pc050607_openlibrary.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pc050607_openlibrary.MainViewModel
import com.example.pc050607_openlibrary.ui.theme.Pc050607_openlibraryTheme

enum class App() {
    Main,
    Search,
    Cached
}
@Composable
fun App(
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val viewModel: MainViewModel = viewModel()

    Scaffold (
        topBar = {
            AppBar(
                canNavigateBack = backStackEntry?.destination?.route != "Main",
                navigateUp = { navController.navigateUp() }
            )
        }
    ) {innerPadding ->
        NavHost(
            navController = navController,
            startDestination = App.Main.name,
            modifier = Modifier
                .padding(innerPadding)
        ) {
            composable(App.Main.name) {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                ) {
                    Button(onClick = { navController.navigate(App.Search.name) }) {
                        Text("Pesquisar Livros")
                    }
                    Button(onClick = { navController.navigate(App.Cached.name) }) {
                        Text("Pesquisas em Cache")
                    }
                }
            }
            composable(App.Search.name) {
                SearchScreen(viewModel)
            }
            composable(App.Cached.name) {
                CachedScreen(viewModel)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    Pc050607_openlibraryTheme {
        App()
    }
}