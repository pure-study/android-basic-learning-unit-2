package net.will.kotlinfundamentals.lambda

fun main() {
    val treatFunction = trickOrTreat(false) { "$it quarters" }
    println("See what's output as of now.")

    val trickFunction = trickOrTreat(true, null)
    repeat(4) {
        println(it)
        treatFunction()
    }
    trickFunction()
}

fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    return if (isTrick) {
        trick
    } else {
        if (extraTreat != null) {
            println(extraTreat(5))  // this line actually not executed for multiple times
        }
        treat
    }
}

val trick = {
    println("No treats!")
}

val treat: () -> Unit = {
    println("Have a treat!")
}
