package com.example.pc050607_openlibrary.repository

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

public class TypeConverter {
    @TypeConverter
    fun fromConsultList(consult: List<OpenLibBook?>?): String? {
        val type = object : TypeToken<List<OpenLibBook>>() {}.type
        return Gson().toJson(consult, type)
    }
    @TypeConverter
    fun toConsultList(consultString: String?): List<OpenLibBook>? {
        val type = object : TypeToken<List<OpenLibBook>>() {}.type
        return Gson().fromJson(consultString, type)
    }

}