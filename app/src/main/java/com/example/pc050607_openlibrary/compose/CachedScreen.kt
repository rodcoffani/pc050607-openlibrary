package com.example.pc050607_openlibrary.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pc050607_openlibrary.MainViewModel

@Composable
fun CachedScreen(
    viewModel: MainViewModel = viewModel()
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
    ) {
        Text(
            text = "PESQUISAS EM CACHE",
            style = TextStyle(
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
            ),
            modifier = Modifier
                .padding(16.dp)
        )
        Button(onClick = { viewModel.clearAllBooks() }) {
            Text("Limpar cache")
        }
        if (viewModel.books.isEmpty())
            Text(
                "Nenhuma pesquisa em cache",
                style = MaterialTheme.typography.bodyLarge
            )
        else {
            LazyColumn {
                itemsIndexed(viewModel.books) { _, _ ->
                    CachedSearchCard(
                        search = "Test",
                        numFound = 10
                    )
                }
            }
        }
    }
}