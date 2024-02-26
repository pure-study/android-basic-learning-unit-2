package net.will.kotlinfundamentals

fun main() {
    // this main() turns to be unnecessary with UTs existing
    val winningBid = Bid(5000, "Private Collector")

    println("Item A is sold at ${auctionPrice(winningBid, 2000)}.")
    println("Item B is sold at ${auctionPrice(null, 3000)}.")
}

class Bid(val amount: Int, val bidder: String)

fun auctionPrice(bid: Bid?, minimumPrice: Int): Int {
    val bidAmount = bid?.amount ?: 0
    return if (bidAmount > minimumPrice) bidAmount else minimumPrice
}