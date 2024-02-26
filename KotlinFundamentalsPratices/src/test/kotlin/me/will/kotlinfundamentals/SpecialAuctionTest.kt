package me.will.kotlinfundamentals

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class SpecialAuctionTest {
    @Test
    fun `one very basic start of UT`() {
        assertNotNull(Bid(1, "test"))
    }

    @Test
    fun `test auctionPrice - basic happy path`() {
        val bid = Bid(5000, "Private Collector")
        assertEquals(5000, auctionPrice(bid, 2000))
    }

    @Test
    fun `test auctionPrice - 'bid' should supports null`() {
        assertEquals(3000, auctionPrice(null, 3000))
    }

    @Test
    fun `test auctionPrice - bid amount lower than the minimum`() {
        val bid = Bid(1000, "Private Collector")
        assertEquals(1000, auctionPrice(bid, 2000))
    }
}
