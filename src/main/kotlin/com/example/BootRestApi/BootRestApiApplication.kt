package com.example.BootRestApi

import com.example.BootRestApi.domain.Person
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class BootRestApiApplication{

	@GetMapping
	fun start(): Person{
		return Person(lastName = "Okeke")
	}
}

fun main(args: Array<String>) {
	runApplication<BootRestApiApplication>(*args)
}
