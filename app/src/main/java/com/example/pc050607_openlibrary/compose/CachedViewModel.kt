package com.example.pc050607_openlibrary.compose

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pc050607_openlibrary.repository.OpenLibConsult
import com.example.pc050607_openlibrary.repository.OpenLibConsultRepository
import kotlinx.coroutines.launch

class CachedViewModel(private val openLibConsultRepository: OpenLibConsultRepository): ViewModel() {

    var consults = mutableStateListOf<OpenLibConsult>()

    init {
        viewModelScope.launch {
            openLibConsultRepository.getAllConsults().collect {
                consults.clear()
                it.forEach { c -> consults.add(c) }
            }
        }
    }

    fun clearAllConsults() {
        viewModelScope.launch {
            openLibConsultRepository.deleteAllConsults()
        }
    }
}