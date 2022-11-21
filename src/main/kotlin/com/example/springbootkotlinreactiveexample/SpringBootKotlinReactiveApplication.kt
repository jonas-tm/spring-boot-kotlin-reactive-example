package com.example.springbootkotlinreactiveexample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


//@TypeHint(
//	types = [News::class],
//	access = [TypeAccess.DECLARED_CONSTRUCTORS, TypeAccess.PUBLIC_METHODS]
//)
@SpringBootApplication
class SpringBootKotlinReactiveApplication

fun main(args: Array<String>) {
	runApplication<SpringBootKotlinReactiveApplication>(*args)
}
