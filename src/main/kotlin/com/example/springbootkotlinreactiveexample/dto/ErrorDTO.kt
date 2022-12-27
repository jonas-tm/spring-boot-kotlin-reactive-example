package com.example.springbootkotlinreactiveexample.dto

import kotlinx.serialization.Serializable


@Serializable
data class ErrorDTO(
    val msg: String,
    val fields: Map<String, String> = emptyMap()
)