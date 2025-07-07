package id.my.hendisantika.kotlinsandbox.controller

import kotlinx.coroutines.runBlocking
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.function.ServerResponse.async

/**
 * Created by IntelliJ IDEA.
 * Project : kotlin-sandbox
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 08/07/25
 * Time: 06.02
 * To change this template use File | Settings | File Templates.
 */
@RestController
class HomeController(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {
    @GetMapping("/")
    fun index(): String {
        return runBlocking {
            val result = async {
                "john"
            }
            val result2 = async {
                "doe"
            }
            "${result.await()} ${result2.await()}"
        }
    }
}