package com.example.urlshortener.service

import com.example.urlshortener.dto.UrlMappingDTO
import com.example.urlshortener.entity.UrlMapping
import com.example.urlshortener.exception.NotFoundException
import com.example.urlshortener.repository.UrlMappingRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.random.Random

@Service
class UrlShortenerService(
    private val urlMappingRepository: UrlMappingRepository
) {

    @Value("\${app.shortUrlBase:http://localhost:8080}")
    private val baseUrl: String = "http://localhost:8080"

    @Value("\${app.shortCodeLength:6}")
    private val shortCodeLength: Int = 6

    private val alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"

    @Transactional
    fun createLongToShortUrlMapping(urlMappingDTO: UrlMappingDTO): UrlMapping {

        val shortCode: String = generateUniqueShortUrlCode(shortCodeLength)

        val urlMapping = UrlMapping(
            shortCode = shortCode,
            longUrl = urlMappingDTO.longUrl
        )
        return urlMappingRepository.save(urlMapping)
    }

    fun getMapping(shortCode: String): UrlMapping =
        urlMappingRepository.findByShortCode(shortCode)
            ?: throw NotFoundException("No URL resolution found with $shortCode as short code.")

    private fun generateUniqueShortUrlCode(length: Int): String {
        var shortCode: String
        do {
            shortCode = generateShortUrlCode(length)
        } while (urlMappingRepository.existsByShortCode(shortCode))
        return shortCode
    }

    private fun generateShortUrlCode(length: Int): String {
        val stringBuilder = StringBuilder()
        for (i in 0 until length) {
            val randomIndex = Random.nextInt(alphabet.length)
            stringBuilder.append(alphabet[randomIndex])
        }
        return stringBuilder.toString()
    }

    fun buildShortUrl(shortCode: String): String =
        "$baseUrl/$shortCode"

}