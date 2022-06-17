package com.example.springbootkotlinreactive.dto

data class ErrorDTO(
    val msg: String,
    val fields: Map<String, String> = emptyMap()
)