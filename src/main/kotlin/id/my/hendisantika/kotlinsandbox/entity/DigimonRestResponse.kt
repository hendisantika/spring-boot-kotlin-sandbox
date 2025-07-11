package id.my.hendisantika.kotlinsandbox.entity

import kotlinx.serialization.Serializable

/**
 * Created by IntelliJ IDEA.
 * Project : kotlin-sandbox
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 08/07/25
 * Time: 05.57
 * To change this template use File | Settings | File Templates.
 */
@Serializable
data class DigimonRestResponse(
    val name: String,
    val img: String,
    val level: String
)