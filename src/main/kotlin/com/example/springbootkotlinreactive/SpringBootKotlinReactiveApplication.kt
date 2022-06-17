package com.example.springbootkotlinreactive

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootKotlinReactiveApplication

fun main(args: Array<String>) {
	runApplication<SpringBootKotlinReactiveApplication>(*args)
}
