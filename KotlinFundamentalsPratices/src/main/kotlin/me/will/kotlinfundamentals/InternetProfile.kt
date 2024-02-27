package me.will.kotlinfundamentals

fun main() {
    val amanda = Person("Amanda", 33, "play tennis")
    val atiqah = Person("Atiqah", 28, "climb", amanda)

    amanda.showProfile()
    atiqah.showProfile()

    val bob = Person("Bob", 40)
    val alice = Person(name = "Alice", age = 35, referrer = bob)
    bob.showProfile()
    alice.showProfile()
}

class Person(
    private val name: String,
    private val age: Int,
    private val hobby: String? = null,
    private val referrer: Person? = null
) {
    fun showProfile() {
        println("Name: $name")
        println("Age: $age")
        hobby?.let { print("Likes to $it. ") }
        println(referrerInfo())
        println()
    }

    fun referrerInfo(): String {
        var finalInfo = ""
        if (referrer != null) {
            finalInfo += "Has a referrer named ${referrer.name}"
            finalInfo += if (referrer.hobby != null) {
                ", who likes to ${referrer.hobby}."
            } else {
                "."
            }
        } else {
            finalInfo += "Doesn't have a referrer."
        }

        return finalInfo
    }
}