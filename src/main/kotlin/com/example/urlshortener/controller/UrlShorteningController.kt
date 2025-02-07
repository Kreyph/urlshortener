package com.example.urlshortener.controller

import com.example.urlshortener.dto.UrlMappingDTO
import com.example.urlshortener.service.UrlShortenerService
import jakarta.validation.Valid
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/urls")
class UrlShorteningController(
    private val urlShortenerService: UrlShortenerService
) {
    // Returning no content in the response for simplicity
    @PostMapping
    fun createShortUrl(@RequestBody @Valid urlMappingDTO: UrlMappingDTO): ResponseEntity<Void> {
        val mapping = urlShortenerService.createLongToShortUrlMapping(urlMappingDTO)
        val shortUrl = urlShortenerService.buildShortUrl(mapping.shortCode)

        return ResponseEntity.status(HttpStatus.CREATED)
            .header(HttpHeaders.LOCATION, shortUrl)
            .build()
    }
}