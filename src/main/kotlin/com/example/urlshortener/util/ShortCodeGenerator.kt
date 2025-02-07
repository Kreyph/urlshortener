package com.example.urlshortener.util

import org.springframework.stereotype.Component
import kotlin.random.Random

@Component
class ShortCodeGenerator {

    private val alphabet: String = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"

    fun generateShortCode(length: Int): String =
        (1..length)
            .map { alphabet.random() }
            .joinToString("")

}