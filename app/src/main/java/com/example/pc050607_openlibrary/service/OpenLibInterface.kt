package com.example.pc050607_openlibrary.service

import retrofit2.http.GET
import retrofit2.http.Query

interface OpenLibApiInterface {
    @GET("/search.json")
    suspend fun getDataByTitle (
        @Query("q") title: String
    ) : OpenLibResponse
}