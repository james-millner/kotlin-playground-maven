
import org.junit.Test
import kotlin.test.assertEquals

class MarvelApiTest {
    @Test fun testMD5Generation() : Unit {
        val test = "testing"

        assertEquals("ae2b1fca515949e5d54fb22b8ed95575", test.md5())
    }
}
