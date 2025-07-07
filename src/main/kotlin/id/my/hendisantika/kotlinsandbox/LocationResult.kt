package id.my.hendisantika.kotlinsandbox

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
sealed class LocationResult {
    class SuccessOne(val location: LocationRestResponse) : LocationResult()
    class SuccessMany(val locations: List<LocationRestResponse>) : LocationResult()
    class Error(val message: String) : LocationResult()
}