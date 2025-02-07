package com.example.urlshortener.controller

import com.example.urlshortener.service.UrlShortenerService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.servlet.view.RedirectView

@Controller
class UrlResolutionController(
    private val urlShortenerService: UrlShortenerService
) {

    private val logger = LoggerFactory.getLogger(UrlResolutionController::class.java)

    @GetMapping("/{shortCode}")
    fun redirectToOriginalUrl(@PathVariable shortCode: String): RedirectView {
        val mapping = urlShortenerService.getMapping(shortCode)
        logger.info("Resolved the short code $shortCode to ${mapping.longUrl}. Redirecting...")
        return RedirectView(mapping.longUrl)
    }
}