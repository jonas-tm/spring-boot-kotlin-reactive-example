package com.example.springbootkotlinreactiveexample.repository

import com.example.springbootkotlinreactiveexample.data.News
import kotlinx.coroutines.flow.Flow
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface NewsRepository : CoroutineCrudRepository<News, Long> {
    override fun findAll(): Flow<News>
    override suspend fun findById(id: Long): News?
    override suspend fun existsById(id: Long): Boolean
    override suspend fun <S : News> save(entity: S): News
    override suspend fun deleteById(id: Long)
}