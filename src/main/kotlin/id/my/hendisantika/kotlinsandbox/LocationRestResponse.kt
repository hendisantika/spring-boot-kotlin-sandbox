package id.my.hendisantika.kotlinsandbox

import kotlinx.serialization.Serializable

/**
 * Created by IntelliJ IDEA.
 * Project : kotlin-sandbox
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 08/07/25
 * Time: 05.56
 * To change this template use File | Settings | File Templates.
 */
@Serializable
data class LocationRestResponse(
    val id: Int,
    val name: String,
    val region: LocationRegion,
    val names: List<LocationName>,
    val areas: List<LocationArea>
)

@Serializable
data class LocationRegion(
    val name: String,
    val url: String
)

@Serializable
data class LocationName(
    val name: String,
    val language: LocationLanguage
)
