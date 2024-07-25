package com.example.pc050607_openlibrary

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    var author by mutableStateOf("")
    var loading by mutableStateOf(true)
    fun searchBook() {
        author = ""
        loading = true

        viewModelScope.launch {
            try {
//                val book = api.getBook
                author = "Teste"
            } catch (e: Exception) {
                author = "Error"
            } finally {
                loading = false
            }
        }
    }
}