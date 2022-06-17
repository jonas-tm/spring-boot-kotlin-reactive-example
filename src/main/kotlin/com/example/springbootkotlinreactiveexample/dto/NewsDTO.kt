package com.example.springbootkotlinreactiveexample.dto

import com.example.springbootkotlinreactiveexample.data.News
import com.fasterxml.jackson.annotation.JsonProperty

data class NewsDTO(
    val id: Long = 0,
    val title: String,
    val text: String,
    val url: String,
    @JsonProperty("image_url")
    val imageUrl: String? = null
)

fun NewsDTO.toData(): News {
    return News(id, title, text, url, imageUrl)
}

// Kotlin Serialization Version
//import kotlinx.serialization.SerialName
//import kotlinx.serialization.Serializable
//@Serializable
//data class NewsDTO(
//    val id: Long = 0,
//    val title: String,
//    val text: String,
//    val url: String,
//    @SerialName("image_url")
//    val imageUrl: String? = null
//)