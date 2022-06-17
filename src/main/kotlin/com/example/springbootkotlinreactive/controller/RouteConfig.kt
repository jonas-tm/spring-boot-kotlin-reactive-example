package com.example.springbootkotlinreactive.controller

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.coRouter

const val NEWS_ID = "newsID"

@Configuration
class RouteConfig (
    private val handler: Handler
) {
    @Bean
    fun apiRouter() = coRouter {
        ("/api/v1" and accept(MediaType.APPLICATION_JSON)).nest {
            "/news".nest {
                GET("", handler::getNewsList)
                GET("/{$NEWS_ID}", handler::getNews)
                POST("", handler::addNews)
            }
        }
    }
}