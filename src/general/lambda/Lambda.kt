package general.lambda

import kotlin.system.measureTimeMillis

fun main() {
    val user = User()
    user.testBlock { person ->
        person.age *= 2
        person
    }
    println(user)

    foo()
    fooo()
    boo()
    booo()
    koo()
    loo()
}


fun User.testBlock(block: User.(Person) -> Person): User {
    val newPerson = block(Person("I'm some person", 18))
    person = newPerson
    return this
}

fun foo() {
    println("foo")
    listOf(1, 2, 3, 4, 5).forEach lit@{
        if (it == 3) return@lit // локальный возврат внутри лямбды, то есть к циклу forEach
        print(it)
    }
    println(" выполнится с использованием явной метки(lit@)")
}

fun fooo() {
    println("fooo")
    run lit@{
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return@lit // локальный возврат из лямбды
            print(it)
        }
    }
    println(" выполнится с использованием явной метки(lit@)")
}

fun boo() {
    println("boo")
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return@forEach // локальный возврат внутри лямбды, то есть к циклу forEach
        print(it)
    }
    println(" выполнится с использованием неявной метки(forEach@")
}

fun booo() {
    println("booo")
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) {
            println()
            return
        }
        print(it)
    }
    println(" booo ")
}

fun koo() {
    println("koo")
    listOf(1, 2, 3, 4, 5).forEach(
        fun(value: Int) {
            if (value == 3) return  // локальный возврат внутри анонимной функци, то есть к циклу forEach
            print(value)
        })
    println(" выполнится с использованием анонимной функции")
}

fun loo() {
    println("loo")
    run loop@{
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return@loop // нелокальный возврат из лямбды к вызывающему run
            print(it)
        }
    }
    print(" выполнится с использованием вложенной метки")
}


open class User() {
    lateinit var person: Person
    open fun kek() = println("kek ${person.name} ${person.age}")
    override fun toString(): String {
        return "User(${person.name} ${person.age})"
    }
}

class Person(var name: String, var age: Int)