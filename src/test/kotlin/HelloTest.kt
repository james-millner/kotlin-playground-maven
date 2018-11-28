package hello.tests

import getHelloString
import org.junit.Test
import kotlin.test.assertEquals

class HelloTest {
    @Test fun testAssert() : Unit {
        assertEquals("Hello, world!", getHelloString())
    }
}
