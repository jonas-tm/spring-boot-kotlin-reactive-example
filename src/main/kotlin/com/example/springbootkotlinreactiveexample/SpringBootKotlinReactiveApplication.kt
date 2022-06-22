package com.example.springbootkotlinreactiveexample

import com.example.springbootkotlinreactiveexample.data.News
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.nativex.hint.TypeAccess
import org.springframework.nativex.hint.TypeHint

@TypeHint(
	types = [News::class],
	access = [TypeAccess.DECLARED_CONSTRUCTORS, TypeAccess.PUBLIC_METHODS]
)
@SpringBootApplication
class SpringBootKotlinReactiveApplication

fun main(args: Array<String>) {
	runApplication<SpringBootKotlinReactiveApplication>(*args)
}
