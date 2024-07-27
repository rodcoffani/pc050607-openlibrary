package com.example.pc050607_openlibrary.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CachedSearchCard(
    title: String = "",
    author: String = "",
    firstSentence: String? = "",
    numPages: Int = 0,
    publishYear: Int = 0,
) {
    Card (
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
    ) {
        Column (
            modifier = Modifier
                .padding(4.dp)
        ) {
            Text(text = "Título: $title")
            Text(text = "Autor: $author")
            Text(text = "Primeira frase: $firstSentence")
            Text(text = "Número de páginas: $numPages")
            Text(text = "Ano de publicação: $publishYear")
        }
    }
}

@Preview
@Composable
fun CachedSearchCarPreview() {
    CachedSearchCard()
}