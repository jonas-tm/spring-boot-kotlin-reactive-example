# Spring Boot Kotlin Reactive Server Example

This repository contains a simple example Spring Boot Webserver using reactive API's with Kotlin Coroutines.

### Used technologies
- Spring Webflux (reactive REST endpoints)
- Spring Data R2DBC (reactive database access)
- H2 in memory database
- Routes defined with Kotlin DSL (`RouteConfig.kt`)

### Endpoints
- **GET**  `/api/v1/news` -> List all news entries in database
- **GET**  `/api/v1/news/{id}` -> Get specific news entry by id from database
- **POST** `/api/v1/news` -> Add news entry to database

### Known issues
- Spring Native: Server is currently not working correctly when compiled to native-image