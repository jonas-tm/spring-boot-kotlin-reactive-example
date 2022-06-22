# Spring Boot Kotlin Reactive Server Example

This repository contains a simple example Spring Boot Webserver using reactive API's with Kotlin Coroutines.

### Used technologies
- Spring Webflux (reactive REST endpoints)
- Spring Data R2DBC (reactive database access)
- H2 in memory database
- Spring Native GraalVM builds
- Routes defined with Kotlin DSL (`RouteConfig.kt`)
- KotlinX Serialization (native not yet working correctly)

### Endpoints
- **GET**  `/api/v1/news` -> List all news entries in database
- **GET**  `/api/v1/news/{id}` -> Get specific news entry by id from database
- **POST** `/api/v1/news` -> Add news entry to database

## Build & Run native image

### Requirements
- GraalVM installed and set as environment variable `JAVA_HOME` (sdkman easiest variant)
- native-image installed (use `gu`) and reachable

### Steps
- Build using `./gradlew :nativeCompile`
- Run using `./build/native/nativeCompile/spring-boot-kotlin-reactive-example `

### Known Issues
- Native image is using Jackson serializer instead of KotlinX
- Native tests not working due to mock dependencies