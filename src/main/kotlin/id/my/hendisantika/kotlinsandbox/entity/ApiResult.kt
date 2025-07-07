package id.my.hendisantika.kotlinsandbox.entity

/**
 * Created by IntelliJ IDEA.
 * Project : kotlin-sandbox
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 08/07/25
 * Time: 05.55
 * To change this template use File | Settings | File Templates.
 */
sealed class ApiResult<T> {
    data class Success<T>(val data: T) : ApiResult<T>()
    data class Error<T>(val message: String) : ApiResult<T>()
}

fun <T> ApiResult<T>.getOrNull(): T? = if (this is ApiResult.Success) data else null
fun <T> ApiResult<T>.getOrDefault(default: T): T = if (this is ApiResult.Success) data else default