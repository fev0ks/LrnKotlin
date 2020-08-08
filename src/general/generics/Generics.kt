package general.generics


//import com.sun.org.slf4j.internal.Logger
//import com.sun.org.slf4j.internal.LoggerFactory
import kotlin.test.assertEquals

interface Keks {

}
//сохраняем тип дженерика при встраивании
//inline fun <reified T> logger(): Logger = LoggerFactory.getLogger(T::class.java)

open class User(var name: String, var health: Int
//                , private val log: Logger = logger<User>()
) {
    operator fun component1() = name
    operator fun component2() = health

    constructor(name: String) : this(name, health = 100) {
        health = 99
    }

    open fun kek() = println("kek $name $health")
    override fun toString(): String {
        return "User(name='$name', health=$health)"
    }

}

open class Person(var person: String) : User("def", 100) {
    override fun kek() = println("Person $person $name $health")
    fun pup() = println("popopou")
}

class Person2(person: String, var ammo: Int) : Person(person) {
    override fun kek() = println("Person2 $person $ammo - $name $health")
}

abstract class Source<out T> {
    abstract fun nextT(): T?
}

class SourceImpl<T>(private var t: List<T>) : Source<T>() {
    private var count = t.size
    override fun nextT(): T? {
        count -= 1
        return if (count >= 0)
            t[count]
        else
            null
    }

    override fun toString(): String {
        return "SourceImpl(t=$t)"
    }

}

class ParameterizedProducer<out T>(private val value: T) {
    fun get(): T {
        return value
    }

    override fun toString(): String {
        return "ParameterizedProducer(value=$value)"
    }
}

class ParameterizedConsumer<in T> {
    fun toString(value: T): String {
        return value.toString()
    }
}

fun fill(dest: Array<in Int>, value: Int) {
    dest[0]= value
}

fun printArray(array: Array<*>) {
    array.forEach { println(it) }
}

fun <T: Comparable<T>> sort(list: List<T>): List<T> {
    return list.sorted()
}

fun main() {

    val parameterizedProducer = ParameterizedProducer(Person2("I'm person", 123))
    val ref: ParameterizedProducer<User> = parameterizedProducer
    ref.get().kek()
    println(ref)

    val parameterizedConsumer = ParameterizedConsumer<Person>()
    val consumer: ParameterizedConsumer<Person2> = parameterizedConsumer
    consumer.toString(Person2("I'm person", 123))
    println(ref)

    val data: Array<Number> = arrayOf(1)
    fill(data, 123)
    println(data[0])
    printArray(data)

    val listOfInts = listOf(5,2,3,4,1)
    val sorted = sort(listOfInts)
    assertEquals(sorted, listOf(1,2,3,4,5))

}


