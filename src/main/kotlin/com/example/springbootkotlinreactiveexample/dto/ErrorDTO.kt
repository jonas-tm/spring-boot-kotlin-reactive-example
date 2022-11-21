package com.example.springbootkotlinreactiveexample.dto

import kotlinx.serialization.Serializable
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding

@RegisterReflectionForBinding
@Serializable
data class ErrorDTO(
    val msg: String,
    val fields: Map<String, String> = emptyMap()
)