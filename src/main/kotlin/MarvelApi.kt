import java.math.BigInteger
import java.security.MessageDigest
import java.time.Instant

fun main(args : Array<String>) {

    var pubKey = args.get(0)
    var privateKey = args.get(1)

    val characterFullURL = getURL("/characters", pubKey, privateKey);

    println(characterFullURL)

    var r = khttp.get(characterFullURL, buildHeaders())
    println(r.statusCode)
    println(r.headers["content-type"])
    println(r.text)
    println(r.headers.size)
}

fun buildHeaders() : Map<String, String> {
    return mapOf("Content-Type" to "application/json")
}

fun getURL(endpoint : String, publicKey : String, privateKey : String) : String {
    val baseURL = "https://gateway.marvel.com:443/v1/public"

    var ts = Instant.now().toEpochMilli();
    var hash = ts.toString() + privateKey + publicKey

    return baseURL + endpoint + "?ts=" + ts.toString() + "&apikey=" + publicKey + "&hash=" + hash.md5() + "&limit=1"
}

fun String.md5(): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
}

