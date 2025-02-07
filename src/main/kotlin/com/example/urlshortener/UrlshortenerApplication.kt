package com.example.urlshortener

import com.example.urlshortener.dto.UrlMappingDTO
import com.example.urlshortener.service.UrlShortenerService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext

@SpringBootApplication
class UrlshortenerApplication

fun main(args: Array<String>) {
//	runApplication<UrlshortenerApplication>(*args)

	val context: ApplicationContext = runApplication<UrlshortenerApplication>(*args)

	val urlMappingService = context.getBean(UrlShortenerService::class.java)
	val urlMappingDTO = UrlMappingDTO (
		longUrl = "https://www.google.com/"
	)
	val urlMapping = urlMappingService.createLongToShortUrlMapping(urlMappingDTO);
	println(urlMappingService.buildShortUrl(urlMapping.shortCode))


}