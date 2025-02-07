package com.example.urlshortener.util

import org.springframework.stereotype.Component
import kotlin.random.Random

@Component
class ShortCodeGenerator {

    private val alphabet: String = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"

    fun generateShortCode(length: Int): String {
        val stringBuilder = StringBuilder()
        for (i in 0 until length) {
            val randomIndex = Random.nextInt(alphabet.length)
            stringBuilder.append(alphabet[randomIndex])
        }
        return stringBuilder.toString()
    }

}