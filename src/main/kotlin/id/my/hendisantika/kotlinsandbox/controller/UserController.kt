package id.my.hendisantika.kotlinsandbox.controller

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by IntelliJ IDEA.
 * Project : kotlin-sandbox
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 08/07/25
 * Time: 06.09
 * To change this template use File | Settings | File Templates.
 */
@RestController
class UserController {
    @GetMapping("/users")
    fun getUsers(): List<String> {
        return runBlocking {
            val users = listOf("John", "Jane", "Bob", "Alice")
            val deferredUsers = users.map { user ->
                async {
                    // Simulate some processing time
                    delay(100)
                    user.uppercase()
                }
            }
            deferredUsers.awaitAll()
        }
    }

    @GetMapping("/users/count")
    fun getUserCount(): Map<String, Int> {
        return runBlocking {
            val count = async {
                // Simulate database query
                delay(200)
                4
            }
            mapOf("count" to count.await())
        }
    }
}
