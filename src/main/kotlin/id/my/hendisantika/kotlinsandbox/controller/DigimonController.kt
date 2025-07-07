package id.my.hendisantika.kotlinsandbox.controller

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import okhttp3.OkHttpClient
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
    data class Digimon(val name: String, val img: String, val level: String)

    sealed class DigimonResult {
        data class Success(val digimon: Digimon) : DigimonResult()
        data class Error(val message: String) : DigimonResult()
    }

    private val client = OkHttpClient()
    private val mapper = jacksonObjectMapper()
}