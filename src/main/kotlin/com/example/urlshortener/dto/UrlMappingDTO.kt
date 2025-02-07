package com.example.urlshortener.dto

import jakarta.validation.constraints.NotBlank
import org.hibernate.validator.constraints.URL

data class UrlMappingDTO (

    @field:NotBlank(message = "The URL cannot be blank")
    @field:URL(message = "The URL provided is invalid")
    val longUrl: String
)