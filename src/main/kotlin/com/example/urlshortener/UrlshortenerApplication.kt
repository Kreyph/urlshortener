package com.example.urlshortener

import com.example.urlshortener.dto.UrlMappingDTO
import com.example.urlshortener.service.UrlShortenerService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext

@SpringBootApplication
class UrlshortenerApplication

fun main(args: Array<String>) {
	runApplication<UrlshortenerApplication>(*args)
}