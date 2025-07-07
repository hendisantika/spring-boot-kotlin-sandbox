package id.my.hendisantika.kotlinsandbox.controller

import kotlinx.serialization.Serializable
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

@Serializable
data class Pokemon(
    val id: Int,
    val name: String,
    val weight: Int,
    val height: Int
)

@RestController
class PokemonController {
    @GetMapping("/pokemonx/{id}")
    fun getPokemonById(@PathVariable id: Int): PokemonOperationResult {
        return fetchPokemon(id)
    }

    fun fetchPokemon(id: Int): PokemonOperationResult {
        val request = Request.Builder()
            .url("https://pokeapi.co/api/v2/pokemon/$id")
            .build()

        OkHttpClient().newCall(request).execute().use { response ->
            if (!response.isSuccessful) {
                return PokemonOperationResult.Error("Failed to fetch Pokemon: HTTP ${response.code}")
            }
            val jsonParser = Json {
                ignoreUnknownKeys = true
            }
            val parsed = jsonParser.decodeFromString<Pokemon>(response.body?.string() ?: "")
            return PokemonOperationResult.Success(parsed)
        }
    }
}