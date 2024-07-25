package com.example.pc050607_openlibrary.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface OpenLibConsultDAO {
    @Insert
    suspend fun insert(openLibConsult: OpenLibConsult)

    @Query("SELECT * FROM OpenLibConsult")
    fun getAllConsults(): Flow<List<OpenLibConsult>>

    @Query("DELETE FROM OpenLibConsult")
    suspend fun deleteAllConsults()
}