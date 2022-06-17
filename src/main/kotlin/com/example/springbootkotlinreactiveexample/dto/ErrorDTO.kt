package com.example.springbootkotlinreactiveexample.dto

data class ErrorDTO(
    val msg: String,
    val fields: Map<String, String> = emptyMap()
)