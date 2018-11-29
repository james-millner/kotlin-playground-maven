package hello.tests

import md5
import org.junit.Test
import kotlin.test.assertEquals

class HelloTest {
    @Test fun testAssert() : Unit {
        val test = "testing"

        assertEquals("ae2b1fca515949e5d54fb22b8ed95575", test.md5())
    }
}
