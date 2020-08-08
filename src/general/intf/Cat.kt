package general.intf

class Cat(name: String) : Pet(name) {
    fun meow(): String {
        println("$name says Meow!")
        return "$name says Meow!"
    }
}