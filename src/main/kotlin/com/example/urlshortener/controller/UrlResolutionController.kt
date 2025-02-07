package com.example.urlshortener.controller

import com.example.urlshortener.service.UrlShortenerService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.servlet.view.RedirectView

@Controller
class UrlResolutionController(
    private val urlShortenerService: UrlShortenerService
) {

    @GetMapping("/{shortCode}")
    fun redirectToOriginalUrl(@PathVariable shortCode: String): RedirectView {
        val mapping = urlShortenerService.getMapping(shortCode)
        return RedirectView(mapping.longUrl)
    }
}