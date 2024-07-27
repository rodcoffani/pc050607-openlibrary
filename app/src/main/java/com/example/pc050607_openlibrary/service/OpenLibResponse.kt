package com.example.pc050607_openlibrary.service

import com.google.gson.annotations.SerializedName

data class OpenLibResponse (
    val docs: List<Docs>
)

data class Docs(
    @SerializedName("author_name")
    val authorName: List<String>,

    @SerializedName("first_publish_year")
    val firstPublishYear: Int,

    @SerializedName("first_sentence")
    val firstSentence: List<String>?,

    @SerializedName("title")
    val title: String,

    @SerializedName("number_of_pages_median")
    val numberOfPagesMedian: Int,
)