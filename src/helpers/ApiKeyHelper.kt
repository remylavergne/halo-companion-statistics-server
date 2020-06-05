package dev.remylavergne.halo.helpers

import java.util.*

object ApiKeyHelper {

    fun generate(client: String): ApiKey = ApiKey("$client${UUID.randomUUID().toString().replace("-", "")}")

}

data class ApiKey(val key: String)

enum class Client(val value: String) {
    ANDROID("android"),
    IOS("ios"),
    WEB("web")
}