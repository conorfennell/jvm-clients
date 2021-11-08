package com.idiomcentric.jvm.clients

interface ClientHttp {
    fun get(url: String): String
}