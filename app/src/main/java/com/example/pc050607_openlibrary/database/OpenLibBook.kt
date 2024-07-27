package com.example.pc050607_openlibrary.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class OpenLibBook(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val authorName: String,
    val firstPublishYear: Int,
    val title: String = "",
    val firstSentence: String?,
    val numberOfPagesMedian: Int = 0,
)