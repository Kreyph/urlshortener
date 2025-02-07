package com.example.urlshortener.repository

import com.example.urlshortener.entity.UrlMapping
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UrlMappingRepository : JpaRepository<UrlMapping, Long> {
    fun existsByShortCode(shortCode: String): Boolean
    fun findByShortCode(shortCode: String): UrlMapping?
}