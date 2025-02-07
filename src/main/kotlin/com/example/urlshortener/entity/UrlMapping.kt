package com.example.urlshortener.entity

import jakarta.persistence.*
import java.io.Serializable
import java.time.LocalDateTime

@Entity
@Table(name="url_mappings")
data class UrlMapping (

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,

    @Column(nullable = false, unique = true)
    val shortCode: String,

    @Column(nullable = false)
    val longUrl: String,

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()

) : Serializable