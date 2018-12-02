import khttp.get
import model.MarvelResponse
import service.buildHeaders
import service.getURL
import service.translateResponse

fun main(args : Array<String>) {

    var pubKey = args.get(0)
    var privateKey = args.get(1)

    val characterFullURL = getURL("/characters", pubKey, privateKey);

    var r = get(characterFullURL, buildHeaders())
    println(r.statusCode)

    if(r.statusCode == 200) {

        val marvelResponse = translateResponse(r.text, MarvelResponse.MarvelCharacterResponse::class.java)

        if (marvelResponse != null) {
            println(marvelResponse.attributionText)

            for (result in marvelResponse.data.results) {
                println(result.name)
                for (u in result.urls) {
                    println(u.url)
                }
            }
        }
    } else {
        println("Error: " + r.statusCode)
    }
}

