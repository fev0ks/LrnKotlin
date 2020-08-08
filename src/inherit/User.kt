package inherit

import kotlin.random.Random

open class User(var name: String, var health: Int) {
    operator fun component1() = name
    operator fun component2() = health
    constructor(name: String): this(name, health =100){
        health = 99
    }
    open fun kek() = println("kek")
}

open class Person: User("def", 100){
    override fun kek() = println("not kek")
}

class Person2: Person() {
    override fun kek() = println("not kek2")
    companion object {
        var count = 0
        fun load() {
            count += 1
        }
    }

    fun l() = load()
    fun w() = println(count)
}

data class Dragon(var k: String, var l: Int){

}

fun main(){
    val user = User("kek", 100)
    println("${user.name} - ${user.health}")
    val (n, h) = user
    println("$n - $h")
    val person = Person2()
    person.kek()
    person.l()
    person.l()
    person.w()

    val person2 = Person2()
    person2.kek()
    person2.l()
    person2.l()
    person2.l()
    person2.w()

    val (k,l) = Dragon("lol", 123)
    println("$k - $l")

    val uint: UInt
    uint = (Int.MAX_VALUE + Int.MAX_VALUE).toUInt()
    println(uint)

    println()
    val diceSides = 5
    println((0 until diceSides).map{ Random.nextInt(diceSides + 1) })
    println((0 until diceSides).map{ 1 })
    println((0 until diceSides).map{ 2 }.sum())
}
