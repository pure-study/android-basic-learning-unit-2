package net.will.kotlinfundamentals

class Song(
    private val title: String,
    private val artist: String,
    private val yearPublished: String,
    var playCount: Int = 0
) {
    val isPolular: Boolean
        get() = playCount >= 1000

    fun printDescripition() {
        println("[$title], performed by [$artist], was released in [$yearPublished].")
    }
}

fun main() {
    val fireworks = Song("Fireworks", "Katy Perry", "2013")
    fireworks.playCount++
    fireworks.playCount++
    fireworks.printDescripition()
    println("Play Count: ${fireworks.playCount}, isPolular: ${fireworks.isPolular}")

    fireworks.playCount += 1000
    println("Play Count: ${fireworks.playCount}, isPolular: ${fireworks.isPolular}")
}