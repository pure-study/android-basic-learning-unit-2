package me.will.kotlinfundamentals

open class Phone(private var isScreenLightOn: Boolean = false) {
    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone : Phone() {
    var folded: Boolean = true
        set(value) {
            field = value
            if (value) switchOff() else switchOn()
        }

    override fun switchOn() {
        if (!folded) super.switchOn()
    }

    fun checkFolded() {
        println("Folded: $folded")
    }

    fun printCheckInfo() {
        checkFolded()
        checkPhoneScreenLight()
    }
}

fun main() {
    val foldablePhone = FoldablePhone()
    foldablePhone.printCheckInfo()

    println("===========================")
    foldablePhone.folded = false
    foldablePhone.printCheckInfo()
    foldablePhone.switchOff()
    foldablePhone.printCheckInfo()
    foldablePhone.switchOn()
    foldablePhone.printCheckInfo()
    println("===========================")

    foldablePhone.folded = true
    foldablePhone.printCheckInfo()
}