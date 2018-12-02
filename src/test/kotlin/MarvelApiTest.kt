import extentions.md5
import model.MarvelResponse
import org.junit.Test
import service.translateResponse
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class MarvelApiTest {
    @Test
    fun testMD5Generation(): Unit {
        val test = "testing"

        assertEquals("ae2b1fca515949e5d54fb22b8ed95575", test.md5())
    }

    @Test
    fun testTranslateResponse_Success(): Unit {
        val t = this.javaClass.classLoader.getResource("marvel-character-endpoint.json").readText()
        println(t)

        val model = translateResponse(t, MarvelResponse.MarvelCharacterResponse::class.java)
        assertNotNull(model)
    }

    @Test
    fun testTranslateResponse_Failure(): Unit {
        val t = this.javaClass.classLoader.getResource("marvel-character-endpoint.json").readText()
        println(t)

        val model = translateResponse(t, MarvelResponse.Data::class.java)
        println(model.toString())
    }
}
