import extentions.md5
import model.MarvelResponse
import org.junit.Test
import service.getURL
import service.translateResponse
import java.time.Instant
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class MarvelApiTest {
    @Test
    fun testMD5Generation() {
        val test = "testing"

        assertEquals("ae2b1fca515949e5d54fb22b8ed95575", test.md5())
    }

    @Test
    fun testGetURL() {
        val url = getURL("/characters", "pubKey", "privateKey", Instant.ofEpochMilli(1543748757308L))

        assertEquals("https://gateway.marvel.com:443/v1/public/characters?ts=1543748757308&apikey=pubKey&hash=3f0eace1d01c5fea3ea3dce7a1b7600c&limit=1",
                url)
    }

    @Test
    fun testTranslateResponse_Success() {
        val t = this.javaClass.classLoader.getResource("marvel-character-endpoint.json").readText()
        println(t)

        val model = translateResponse(t, MarvelResponse.MarvelCharacterResponse::class.java)
        assertNotNull(model)
    }

    @Test
    fun testTranslateResponse_Failure() {
        val t = this.javaClass.classLoader.getResource("marvel-character-endpoint.json").readText()
        println(t)

        val model = translateResponse(t, MarvelResponse.Data::class.java)
        println(model.toString())
    }
}
