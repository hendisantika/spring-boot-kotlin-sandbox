package id.my.hendisantika.kotlinsandbox.controller

import id.my.hendisantika.kotlinsandbox.entity.PokemonRestResponse
import id.my.hendisantika.kotlinsandbox.entity.PokemonResult
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

/**
 * Created by IntelliJ IDEA.
 * Project : kotlin-sandbox
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 08/07/25
 * Time: 06.08
 * To change this template use File | Settings | File Templates.
 */

@RestController
class PokemonController {
    @GetMapping("/pokemonx/{id}")
    fun getPokemonById(@PathVariable id: Int): PokemonResult {
        return fetchPokemon(id)
    }

    fun fetchPokemon(id: Int): PokemonResult {
        val request = Request.Builder()
            .url("https://pokeapi.co/api/v2/pokemon/$id")
            .build()

        OkHttpClient().newCall(request).execute().use { response ->
            if (!response.isSuccessful) {
                return PokemonResult.Error("Failed to fetch Pokemon: HTTP ${response.code}")
            }
            val jsonParser = Json {
                ignoreUnknownKeys = true
            }
            val parsed = jsonParser.decodeFromString<PokemonRestResponse>(response.body?.string() ?: "")
            return PokemonResult.Success(parsed)
        }
    }
}
