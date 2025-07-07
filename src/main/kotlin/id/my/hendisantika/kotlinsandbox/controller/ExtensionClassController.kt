package id.my.hendisantika.kotlinsandbox.controller

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
 * Time: 06.00
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/extension_class")
class ExtensionClassController {
    @RequestMapping("/user/{id}")
    fun getUserByID(@PathVariable id: Int): ReqResData? {
        return fetchUserById(id).getOrNull()?.let {
            it.copy(data = it.data.copy(firstName = it.data.firstName.capitalizeWords()))
        }
    }
}