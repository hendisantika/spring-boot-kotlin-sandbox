package id.my.hendisantika.kotlinsandbox.controller

import id.my.hendisantika.kotlinsandbox.entity.LocationResult
import kotlinx.coroutines.runBlocking
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
}