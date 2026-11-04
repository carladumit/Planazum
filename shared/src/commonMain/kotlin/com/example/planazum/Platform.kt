package com.example.planazum

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform