package com.myaxa.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

interface NetworkClient {
    val client: HttpClient
}

fun NetworkClient(
    baseUrl: String,
    json: Json = Json,
): NetworkClient {
    return KtorClient(baseUrl, json)
}

internal class KtorClient(
    private val baseUrl: String,
    private val json: Json,
) : NetworkClient {
    override val client = HttpClient(OkHttp) {
        defaultRequest { url(baseUrl) }

        install(Logging) {
            logger = Logger.SIMPLE
        }

        install(ContentNegotiation) {
            json(json)
        }
    }
}