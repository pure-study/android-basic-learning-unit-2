package me.will.kotlinfundamentals

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class SongCatalogTest {
    @Test
    fun `simple test`() {
        val fireworks = Song("Fireworks", "Katy Perry", "2013")
        fireworks.printDescripition()
        assertTrue {
            with(fireworks) {
                description().contains("Fireworks")
                description().contains("Katy Perry")
                description().contains("2013")
            }
        }

        with(fireworks) {
            playCount++
            playCount++
            assertEquals(2, playCount)
            assertFalse(isPolular)
        }

        with(fireworks) {
            playCount += 1000
            assertTrue(isPolular)
        }
    }

    @Test
    fun `further test with a number format I never saw before`() {
        val meandyou = Song("Me And You", "Lucky Twice", "2007", 1_000_000)
        println("playCount: ${meandyou.playCount}")
        with(meandyou) {
            printDescripition()
            assertTrue {
                description().contains("Me And You")
                description().contains("Lucky Twice")
                description().contains("2007")
            }

            assertTrue(isPolular)
        }
    }
}