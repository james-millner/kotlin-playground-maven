package service

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import extentions.md5
import java.time.Instant

fun buildHeaders(): Map<String, String> {
    return mapOf("Content-Type" to "application/json")
}

fun getURL(endpoint: String, publicKey: String, privateKey: String): String {
    val baseURL = "https://gateway.marvel.com:443/v1/public"

    var ts = Instant.now().toEpochMilli();
    var hash = ts.toString() + privateKey + publicKey

    return baseURL + endpoint + "?ts=" + ts.toString() + "&apikey=" + publicKey + "&hash=" + hash.md5() + "&limit=1"
}

@Throws(JsonSyntaxException::class)
fun <T> translateResponse(json: String, classOfT: Class<T>): T? {
    return Gson().fromJson(json, classOfT)
}