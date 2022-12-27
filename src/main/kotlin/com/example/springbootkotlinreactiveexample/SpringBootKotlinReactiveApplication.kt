package com.example.springbootkotlinreactiveexample

import com.example.springbootkotlinreactiveexample.dto.NewsDTO
import com.example.springbootkotlinreactiveexample.dto.ErrorDTO
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@RegisterReflectionForBinding(classes = [
	NewsDTO::class,
	ErrorDTO::class
])
@SpringBootApplication
class SpringBootKotlinReactiveApplication

fun main(args: Array<String>) {
	runApplication<SpringBootKotlinReactiveApplication>(*args)
}
