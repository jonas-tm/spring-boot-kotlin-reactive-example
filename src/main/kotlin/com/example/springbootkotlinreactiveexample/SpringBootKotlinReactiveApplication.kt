package com.example.springbootkotlinreactiveexample

import com.example.springbootkotlinreactiveexample.data.News
import com.example.springbootkotlinreactiveexample.dto.ErrorDTO
import com.example.springbootkotlinreactiveexample.dto.NewsDTO
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.nativex.hint.TypeAccess
import org.springframework.nativex.hint.TypeHint

@TypeHint(types = [
	News::class,
	NewsDTO::class,
	ErrorDTO::class],
	access = arrayOf(TypeAccess.DECLARED_CONSTRUCTORS, TypeAccess.PUBLIC_METHODS))
@SpringBootApplication
class SpringBootKotlinReactiveApplication

fun main(args: Array<String>) {
	runApplication<SpringBootKotlinReactiveApplication>(*args)
}
