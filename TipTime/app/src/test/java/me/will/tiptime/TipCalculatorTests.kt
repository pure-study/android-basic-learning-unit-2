package me.will.tiptime

import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorTests {
    @Test
    fun calculateTip_20PercentNoRoundup() {
        assertEquals(
            NumberFormat.getCurrencyInstance().format(2.0),
            calculateTip(10.0, tipPercent = 20.0, roundUp = false)
        )
    }

    @Test
    fun calculateTip_20PercentWithRoundup() {
        assertEquals(
            NumberFormat.getCurrencyInstance().format(3.0),
            calculateTip(11.0, tipPercent = 20.0, roundUp = true)
        )
    }
}