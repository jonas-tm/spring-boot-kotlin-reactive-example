package com.example.springbootkotlinreactiveexample.controller

import com.example.springbootkotlinreactiveexample.dto.NewsDTO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


/**
 * This class is needed to for spring aot to register kotlinx serialization for NewsDTO
 * because the plugin does not detect it when using KotlinDSL for routing
 */
@RestController
@RequestMapping("/api/v1/news2")
class Controller{

    @GetMapping
    suspend fun get(): NewsDTO {
        return NewsDTO(1, "Hello", "World", "asd")
    }

}