package com.example.urlshortener.repository

import com.example.urlshortener.entity.UrlMapping
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UrlMappingRepository : JpaRepository<UrlMapping, Long> {
}