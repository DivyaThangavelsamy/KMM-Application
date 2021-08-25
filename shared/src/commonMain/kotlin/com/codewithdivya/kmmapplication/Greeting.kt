package com.codewithdivya.kmmapplication

import io.github.aakira.napier.Napier
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.statement.*
import io.ktor.client.request.*
import kotlinx.serialization.SerialInfo
import kotlinx.serialization.Serializable

@Serializable
data class Hello(
    val title: String
)

class Greeting {
    private val httpClient = HttpClient() {
        install(Logging) {
            level = LogLevel.HEADERS
            logger = object : Logger {
                override fun log(message: String) {
                    Napier.v(tag = "HTTP Client", message = message)
                }

            }
        }
        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true
            })
        }
    }.also { initLogger() }

    @Throws(Exception::class)
    suspend fun greeting(): String {
        return "${getHello().random().title}, ${Platform().platform}!"
    }

    private suspend fun getHello(): List<Hello> {
        return httpClient.get("https://jsonplaceholder.typicode.com/posts")

    }
}

/*
fun daysUntilNewYear() : Int {
    val today = Clock.System.todayAt(TimeZone.currentSystemDefault())
    val closestNewYear = LocalDate(today.year+1, 1, 1)
    return today.daysUntil(closestNewYear)
}*/
