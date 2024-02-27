package me.will.kotlinfundamentals

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class InternetProfileTest {
    @Test
    fun `test referrerInfo(), null referrer`() {
        val bob = Person("Bob", 33, "play tennis")

        assertNotNull(bob.referrerInfo())
        assertEquals("Doesn't have a referrer.", bob.referrerInfo())
    }

    @Test
    fun `test referrerInfo(), valid referrer with null hobby`() {
        val bob = Person("Bob", 33, hobby = null)
        val alice = Person("Alice", 28, "climb", bob)
        assertEquals("Has a referrer named Bob.", alice.referrerInfo())
    }

    @Test
    fun `test referrerInfo(), valid referrer with valid hobby`() {
        val bob = Person("Bob", 33, "play tennis")
        val alice = Person("Alice", 28, "climb", bob)
        assertEquals("Has a referrer named Bob, who likes to play tennis.", alice.referrerInfo())
    }
}