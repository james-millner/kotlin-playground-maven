import khttp.get
import model.MarvelCharacterResponse
import service.buildHeaders
import service.getURL
import service.translateResponse
import java.time.Instant

fun main(args : Array<String>) {

    val pubKey = args[0]
    val privateKey = args[1]

    val characterFullURL = getURL("/characters", pubKey, privateKey, Instant.now())

    val r = get(characterFullURL, buildHeaders())
    println(r.statusCode)

    if(r.statusCode == 200) {

        val marvelResponse = translateResponse(r.text, MarvelCharacterResponse::class.java)
        println(marvelResponse.toString())
    } else {
        println("Error: " + r.statusCode)
    }
}

