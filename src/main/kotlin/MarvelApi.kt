import com.google.gson.Gson
import khttp.get
import model.MarvelResponse
import service.buildHeaders
import service.getURL
import kotlin.test.assertNotNull

fun main(args : Array<String>) {

    var pubKey = args.get(0)
    var privateKey = args.get(1)

    val characterFullURL = getURL("/characters", pubKey, privateKey);

    var r = get(characterFullURL, buildHeaders())
    println(r.statusCode)
    println(r.text)

    var gson = Gson()
    val marvelResponse = gson.fromJson(r.text, MarvelResponse.MarvelCharacterResponse::class.java)

    assertNotNull(marvelResponse)

    for(url in marvelResponse.data.results) {
        println(url.name)
        for(u in url.urls) {
            println(u.url)
        }
    }
}

