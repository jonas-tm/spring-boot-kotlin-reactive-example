package com.example.springbootkotlinreactiveexample.dto

import com.example.springbootkotlinreactiveexample.data.News
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding

@RegisterReflectionForBinding
@Serializable
data class NewsDTO(
    val id: Long = 0,
    val title: String,
    val text: String,
    val url: String,
    @SerialName("image_url")
    val imageUrl: String? = null
)

fun NewsDTO.toData(): News {
    return News(id, title, text, url, imageUrl)
}