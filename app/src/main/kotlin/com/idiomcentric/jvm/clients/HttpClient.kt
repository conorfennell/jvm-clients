package com.idiomcentric.jvm.clients

interface ClientHttp {
    fun get(url: String = "https://www.google.com", port: Int = 443): String
}