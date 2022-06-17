package com.example.springbootkotlinreactiveexample.controller

import com.example.springbootkotlinreactiveexample.data.toDTO
import com.example.springbootkotlinreactiveexample.dto.ErrorDTO
import com.example.springbootkotlinreactiveexample.dto.NewsDTO
import com.example.springbootkotlinreactiveexample.dto.toData
import com.example.springbootkotlinreactiveexample.repository.NewsRepository
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.reactive.awaitSingle
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*

@Component
class Handler(
    private val repository: NewsRepository
) {
    private val log = LoggerFactory.getLogger(javaClass)

    suspend fun getNewsList(req: ServerRequest): ServerResponse {
        val news = repository.findAll().map { it.toDTO() }

        return ServerResponse
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .bodyAndAwait(news)
    }

    suspend fun getNews(req: ServerRequest): ServerResponse {
        val id = req.pathVariable(NEWS_ID).toLongOrNull() ?: return ServerResponse
            .badRequest()
            .bodyValue(ErrorDTO(msg = "Invalid news id in path"))
            .awaitSingle()

        val news = repository.findById(id) ?: return ServerResponse
            .notFound()
            .buildAndAwait()

        return ServerResponse
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValueAndAwait(news.toDTO())
    }

    suspend fun addNews(req: ServerRequest): ServerResponse {
        val news = req.awaitBodyOrNull<NewsDTO>() ?: return ServerResponse
            .badRequest()
            .bodyValue(ErrorDTO(msg = "Invalid body"))
            .awaitSingle()

        val newsToSave = news.copy(id = 0).toData()

        val savedNews = try {
            repository.save(newsToSave)
        } catch (e: Exception) {
            log.error("Error saving news", e)
            return ServerResponse
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .bodyValueAndAwait(ErrorDTO("Error while saving news"))
        }

        return ServerResponse
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValueAndAwait(savedNews)
    }


}