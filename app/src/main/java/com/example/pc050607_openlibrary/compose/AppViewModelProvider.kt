package com.example.pc050607_openlibrary.compose

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pc050607_openlibrary.MainApplication


/**
 * Provides Factory to create instance of ViewModel for the entire Game app
 */
object AppViewModelProvider {
    val Factory = viewModelFactory {

        // Initializer for CachedViewModel
        initializer {
            CachedViewModel(gameApplication().container.openLibConsultRepository)
        }

    }
}

fun CreationExtras.gameApplication(): MainApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MainApplication)