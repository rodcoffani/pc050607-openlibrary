package com.example.pc050607_openlibrary.repository

import kotlinx.coroutines.flow.Flow

class OpenLibConsultRepository(private val openLibConsultDAO: OpenLibConsultDAO){
    suspend fun insertConsult(consult: OpenLibConsult) = openLibConsultDAO.insert(consult)
    suspend fun getAllConsults(): Flow<List<OpenLibConsult>> = openLibConsultDAO.getAllConsults()
    suspend fun deleteAllConsults() = openLibConsultDAO.deleteAllConsults()
}