package com.example.urlshortener.service

import com.example.urlshortener.dto.UrlMappingDTO
import com.example.urlshortener.entity.UrlMapping
import com.example.urlshortener.repository.UrlMappingRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.random.Random

@Service
class UrlMappingService(private val urlMappingRepository: UrlMappingRepository) {

    private val baseUrl: String = "http://localhost:8080"
    private val shortCodeLength: Int = 6
    private val alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"

    @Transactional
    fun createLongToShortUrlMapping(urlMappingDTO: UrlMappingDTO): UrlMapping {

        val shortCode: String = generateShortUrlCode(shortCodeLength)

        val urlMapping = UrlMapping(
            shortCode = shortCode,
            longUrl = urlMappingDTO.longUrl
        )
        return urlMappingRepository.save(urlMapping)
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