package com.example.pc050607_openlibrary

import android.app.Application
import android.content.Context
import android.util.Log
import com.example.pc050607_openlibrary.repository.AppDatabase
import com.example.pc050607_openlibrary.repository.OpenLibConsultRepository

/**
 * REQUIREMENT:
 * You need to specify attribute android:name=".MainApplication" in AndroidManifest.xml
 * Otherwise, this class is not initialized
 */
class MainApplication : Application() {

    // instance to obtain dependencies
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppContainer(this)
        Log.i("MainApplication", "onCreate")
    }
}

/**
 * We want to limit the visibility of Android-related objects to ViewModels and Composable.
 *
 * So, we attach here the repositories to a GameApplication object
 *    so that we can retrieve them in the AppViewModelProvider.
 */
class AppContainer(private val context: Context) {
    val openLibConsultRepository : OpenLibConsultRepository by lazy {
        OpenLibConsultRepository(AppDatabase.getDatabase(context).dao())
    }
}