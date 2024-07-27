package com.example.pc050607_openlibrary

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.pc050607_openlibrary.database.OpenLibBook
import com.example.pc050607_openlibrary.service.OpenLibRepository
import kotlinx.coroutines.launch
import java.util.Locale

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = OpenLibRepository(application)

    var books by mutableStateOf(listOf<OpenLibBook>())
    var label by mutableStateOf("")
    var loading by mutableStateOf(false)

    fun getBookData(t: String) {
        val bookTitle = if (t.trim().isEmpty()) "percy jackson" else t
        loading = true

        viewModelScope.launch {
            try {
                val response = repository.getDataByBookTitle(bookTitle.trim().lowercase())
                val s = "Autor: %s\n" +
                        "Ano de publicação: %d\n" +
                        "Título: %s\n" +
                        "Primeira frase: %s\n" +
                        "Número de páginas: %d\n"


                val doc = response.docs[0]
                val authorName = doc.authorName[0]
                val firstPublishYear = doc.firstPublishYear
                val title = doc.title
                val firstSentence = doc.firstSentence?.firstOrNull()
                val numberOfPages = doc.numberOfPagesMedian

                label = String.format(Locale.US, s, authorName, firstPublishYear, title, firstSentence, numberOfPages)
            } catch (e: Exception) {
                label = "Error: " + e.message
            } finally {
                loading = false
            }
        }
    }

    fun getAllBooks() {
        viewModelScope.launch {
            books = repository.getAllBooks()
        }
    }

    fun clearAllBooks() {
        viewModelScope.launch {
            repository.deleteAllBooks()
            books = listOf<OpenLibBook>()
        }
    }
}