package id.my.hendisantika.kotlinsandbox.entity

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
sealed class DigimonResult {
    data class Success(val digimon: DigimonRestResponse) : DigimonResult()
    data class Error(val message: String) : DigimonResult()
}