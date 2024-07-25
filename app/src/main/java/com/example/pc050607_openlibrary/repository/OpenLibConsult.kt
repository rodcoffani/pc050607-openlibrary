package com.example.pc050607_openlibrary.repository

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class OpenLibConsult (
    @PrimaryKey(autoGenerate = true)
    val numFound: Int = 0,
    val start: Int = 0,
    val numFoundExact: Boolean = false,
    @Embedded
    val docs: OpenLibBook,
)