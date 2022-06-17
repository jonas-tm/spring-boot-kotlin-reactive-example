package com.example.springbootkotlinreactiveexample.data

import com.example.springbootkotlinreactiveexample.dto.NewsDTO
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("news")
data class News(
    @Id
    val id: Long = 0,

    val title: String,
    val text: String,
    val url: String,
    @Column("image_url")
    val imageUrl: String? = null
)

fun News.toDTO(): NewsDTO {
    return NewsDTO(id, title, text, url, imageUrl)
}

