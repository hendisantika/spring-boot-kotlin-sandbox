package id.my.hendisantika.kotlinsandbox.controller

import id.my.hendisantika.kotlinsandbox.entity.LocationRestResponse
import id.my.hendisantika.kotlinsandbox.entity.LocationResult
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by IntelliJ IDEA.
 * Project : kotlin-sandbox
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 08/07/25
 * Time: 06.06
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/locations")
class LocationController {
    @RequestMapping("/{id}")
    fun getById(@PathVariable id: Int): LocationResult {
        return runBlocking {
            pokeAPIGetLocationById(id)
        }
    }

    suspend fun pokeAPIGetLocationById(id: Int): LocationResult {
        val request = Request.Builder()
            .url("https://pokeapi.co/api/v2/location/$id")
            .build()

        val client = OkHttpClient()
        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) {
                return LocationResult.Error("Failed to fetch location: HTTP ${response.code}")
            }
            val json = response.body?.string() ?: return LocationResult.Error("Empty response body")
            val jsonParser = kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true
            }
            val parsed = jsonParser.decodeFromString<LocationRestResponse>(json)
            return LocationResult.SuccessOne(parsed)
        }
    }
}