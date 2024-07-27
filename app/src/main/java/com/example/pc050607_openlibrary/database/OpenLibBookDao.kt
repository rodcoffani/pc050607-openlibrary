package com.example.pc050607_openlibrary.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface OpenLibBookDao {
    @Query("SELECT * FROM books WHERE title = :title LIMIT 1")
    suspend fun getBookByTitle(title: String): OpenLibBook?

    @Insert
    suspend fun insertBook(book: OpenLibBook)

    @Query("SELECT * FROM books")
    suspend fun getAllBooks(): List<OpenLibBook>

    @Query("DELETE FROM books")
    suspend fun deleteAllBooks()
}