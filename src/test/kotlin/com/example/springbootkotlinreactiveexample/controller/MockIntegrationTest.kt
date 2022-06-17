package com.example.springbootkotlinreactiveexample.controller

import com.example.springbootkotlinreactiveexample.data.News
import com.example.springbootkotlinreactiveexample.data.toDTO
import com.example.springbootkotlinreactiveexample.dto.NewsDTO
import com.example.springbootkotlinreactiveexample.repository.NewsRepository
import com.ninjasquad.springmockk.MockkBean
import io.mockk.coEvery
import kotlinx.coroutines.flow.flowOf
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.context.annotation.Import
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody

@WebFluxTest
@Import(RouteConfig::class, Handler::class)
class MockIntegrationTest(
    @Autowired val client: WebTestClient
) {

    @MockkBean
    private lateinit var repository: NewsRepository

    @Test
    fun `GET news by id test`() {
        val news = News(123,"Test", "Some hot news", "test.com")

        coEvery {
            repository.findById(any())
        } coAnswers {
            news
        }

        client
            .get()
            .uri("/api/v1/news/123")
            .exchange()
            .expectStatus().isOk
            .expectBody<News>()
            .isEqualTo(news)
    }

    @Test
    fun `GET all news test`() {
        val news = News(123,"Test", "Some hot news", "test.com")

        coEvery {
            repository.findAll()
        } coAnswers {
            flowOf(news)
        }

        client
            .get()
            .uri("/api/v1/news")
            .exchange()
            .expectStatus().isOk
            .expectBody<Array<NewsDTO>>()
            .isEqualTo(arrayOf(news.toDTO()))
    }

    @Test
    fun `POST news test`() {
        val news = News(123,"Test", "Some hot news", "test.com")

        coEvery {
            repository.findById(any())
        } coAnswers {
            news
        }

        client
            .get()
            .uri("/api/v1/news/123")
            .exchange()
            .expectStatus().isOk
            .expectBody<NewsDTO>()
            .isEqualTo(news.toDTO())
    }


}