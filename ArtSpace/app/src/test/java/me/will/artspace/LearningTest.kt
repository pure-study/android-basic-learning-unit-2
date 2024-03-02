package me.will.artspace

import org.junit.Test

import org.junit.Assert.*

class LearningTest {
    @Test
    fun model_simple() {
        assertEquals(0, 0 % 4)
        assertEquals(0, 4 % 4)
        assertEquals(1, 5 % 4)
        assertEquals(3, 3 % 4)
    }
}