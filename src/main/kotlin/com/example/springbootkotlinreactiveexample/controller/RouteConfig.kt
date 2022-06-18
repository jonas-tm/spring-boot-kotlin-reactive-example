package com.example.springbootkotlinreactiveexample.controller

import com.example.springbootkotlinreactiveexample.dto.ErrorDTO
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.coRouter

const val NEWS_ID = "newsID"

@Configuration
class RouteConfig (
    private val handler: Handler
) {
    @Bean
    fun apiRouter() = coRouter {
        GET("") {
            ServerResponse.ok().bodyValueAndAwait(ErrorDTO("test"))
        }
        ("/api/v1" and accept(MediaType.APPLICATION_JSON)).nest {
            "/news".nest {
                GET("", handler::getNewsList)
                GET("/{$NEWS_ID}", handler::getNews)
                POST("", handler::addNews)
            }
        }
    }
}