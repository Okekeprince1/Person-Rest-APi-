package com.example.BootRestApi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class BootRestApiApplication{

	@GetMapping
	fun start(): String{
		return "RestApi is starting at port 4000"
	}
}

fun main(args: Array<String>) {
	runApplication<BootRestApiApplication>(*args)
}
