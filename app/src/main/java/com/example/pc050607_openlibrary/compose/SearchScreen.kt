package com.example.pc050607_openlibrary.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pc050607_openlibrary.MainViewModel
import com.example.pc050607_openlibrary.ui.theme.Pc050607_openlibraryTheme

@Composable
fun SearchScreen(
    viewModel: MainViewModel = viewModel()
) {
    val textState = remember { mutableStateOf(TextFieldValue()) }
    val textSearch = remember { mutableStateOf("Start") }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
    ) {
        Text(
            text = "INFOS DE LIVROS",
            style = TextStyle(
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
            ),
            modifier = Modifier
                .padding(16.dp)
        )
        TextField(
            value = textState.value,
            onValueChange = { textState.value = it }
        )
        Button(
            onClick = { viewModel.getBookData(textState.value.text) },
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text(text = "Search")
        }
        Button(
            onClick = { viewModel.label = textState.value.text },
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text(text = "Insert test")
        }
        if(viewModel.loading) {
            Text(text = "Buscando...")
        } else {
            Text(text = viewModel.label)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    Pc050607_openlibraryTheme {
        App()
    }
}