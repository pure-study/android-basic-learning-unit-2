package me.will.kotlinfundamentals

class Song(
    private val title: String,
    private val artist: String,
    private val yearPublished: String,
    var playCount: Int = 0
) {
    val isPolular: Boolean
        get() = playCount >= 1000

    fun description(): String {
        return "[$title], performed by [$artist], was released in [$yearPublished]."
    }

    fun printDescripition() {
        println(description())
    }
}