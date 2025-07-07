package id.my.hendisantika.kotlinsandbox.controller

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import id.my.hendisantika.kotlinsandbox.entity.DigimonRestResponse
import id.my.hendisantika.kotlinsandbox.entity.DigimonResult
import okhttp3.OkHttpClient
import org.springframework.http.ResponseEntity
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
 * Time: 05.58
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/digimon")
class DigimonController {
    private val client = OkHttpClient()
    private val mapper = jacksonObjectMapper()

    private fun safeApiCall(block: () -> DigimonRestResponse): DigimonResult {
        return try {
            DigimonResult.Success(block())
        } catch (e: Exception) {
            DigimonResult.Error(e.message ?: "Unknown error")
        }
    }

    @RequestMapping("/{name}")
    fun getDigimonByName(@PathVariable name: String): ResponseEntity<Any> {
        val result = safeApiCall {
            val request = okhttp3.Request.Builder()
                .url("https://digimon-api.vercel.app/api/digimon")
                .build()

            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) {
                    throw RuntimeException("Failed to fetch Digimon: HTTP ${response.code}")
                }

                val body = response.body?.string() ?: throw RuntimeException("Empty response body")

                val typeRef = object : TypeReference<List<DigimonRestResponse>>() {}
                val list: List<DigimonRestResponse> = mapper.readValue(body, typeRef)
                if (list.isEmpty()) {
                    throw RuntimeException("No Digimon found")
                }
                list.find { it.name.lowercase() == name.lowercase() } ?: throw RuntimeException("Digimon not found")
            }
        }
        return result.let {
            when (it) {
                is DigimonResult.Success -> ResponseEntity.ok(it.digimon)
                is DigimonResult.Error -> ResponseEntity.badRequest().body(it.message)
            }
        }
    }
}
