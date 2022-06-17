package com.example.springbootkotlinreactiveexample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootKotlinReactiveApplication

fun main(args: Array<String>) {
	runApplication<SpringBootKotlinReactiveApplication>(*args)
}
