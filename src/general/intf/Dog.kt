package general.intf

class Dog(name: String) : Pet(name) {
    fun woof(): String {
        println("$name says Woof!")
        return "$name says Woof!"
    }
}