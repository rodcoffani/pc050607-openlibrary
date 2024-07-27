package com.example.pc050607_openlibrary.service

import android.content.Context
import com.example.pc050607_openlibrary.database.AppDatabase
import com.example.pc050607_openlibrary.database.OpenLibBook

class OpenLibRepository (context: Context) {
    private val api = RetrofitInstance.api
    private val bookDao = AppDatabase.getDatabase(context).bookDao()

    suspend fun getDataByBookTitle(bookTitle: String): OpenLibResponse {
        val cachedBook = bookDao.getBookByTitle(bookTitle)

        return if (cachedBook != null) {
            OpenLibResponse(
                docs = listOf(
                    Docs(
                        authorName = listOf(cachedBook.authorName),
                        firstPublishYear = cachedBook.firstPublishYear,
                        firstSentence = if (cachedBook.firstSentence.isNullOrBlank()) null else listOf(cachedBook.firstSentence),
                        title = cachedBook.title,
                        numberOfPagesMedian = cachedBook.numberOfPagesMedian
                    )
                )
            )
        } else {
            val response = api.getDataByTitle(bookTitle)
            val firstDoc = response.docs.firstOrNull()

            if (firstDoc != null) {
                val book = OpenLibBook(
                    authorName = firstDoc.authorName.firstOrNull() ?: "",
                    firstPublishYear = firstDoc.firstPublishYear,
                    firstSentence = firstDoc.firstSentence?.firstOrNull() ?: "",
                    title = firstDoc.title,
                    numberOfPagesMedian = firstDoc.numberOfPagesMedian
                )
                bookDao.insertBook(book)
            }
            response
        }
    }

    suspend fun getAllBooks(): List<OpenLibBook> {
        return bookDao.getAllBooks()
    }

    suspend fun deleteAllBooks()  {
        return bookDao.deleteAllBooks()
    }
}