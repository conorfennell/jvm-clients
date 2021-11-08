package com.idiomcentric.jvm.clients

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.time.Duration

open class NativeClient: ClientHttp {
    override fun get(url: String): String {
        val client = HttpClient.newHttpClient()
        val uri = URI.create("$url")
        val request = HttpRequest
            .newBuilder()
            .uri(uri)
            .GET()
            .timeout(Duration.ofMillis(1000))
            .build()

        val response: HttpResponse<String> = client.send(request, HttpResponse.BodyHandlers.ofString())
        return response.body()
    }
}