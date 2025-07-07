package id.my.hendisantika.kotlinsandbox.controller

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
    fun getPokemonById(@PathVariable id: Int): PokemonOperationResult {
        return fetchPokemon(id)
    }
}