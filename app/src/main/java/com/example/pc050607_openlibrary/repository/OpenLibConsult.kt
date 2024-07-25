package com.example.pc050607_openlibrary.repository

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class OpenLibConsult (
    @PrimaryKey(autoGenerate = true)
    val numFound: Int = 0,
    val start: Int,
    val numFoundExact: Boolean,
    @Embedded
    val docs: OpenLibBook,
)