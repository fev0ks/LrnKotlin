package general

import general.Color.*
import general.intf.Cat
import general.intf.Dog
import general.intf.Pet
import java.lang.Exception
import kotlin.random.Random

fun main(args: Array<String>) {
    println("Hello World!")
    val student = Student("Mikhail", 25)
    println(student)
    val student2 = student.copy("Lol")
    println(student2)
    println(sum(1, 2))
    sum3(13, 32132)
    var a = 4
    val b = if (5 % 2 == 0) 1 else 0
    println(
        listOf('a', 'b', 'c').joinToString(
            separator = "", prefix = "(", postfix = ")"
        )
    )

    displaySeparator()
    displaySeparator('/')
    displaySeparator(size = 5)
    displaySeparator(char = '#', size = 5)
    var temp = updateWeather(10)
    println(temp)
    println(mix(RED, YELLOW))

    when (val cat = getPet()) {
        is Cat -> cat.meow()
        is Dog -> cat.woof()
    }

    println(getSound())
    loops(9)

    val q = """"To code,
                #or not to code?""".trimMargin(marginPrefix = "#")
    println("q=$q")

    val regex = """\d{2}.\d{2}.\d{4}""".toRegex()
    print(regex.matches("15.02.2020"))
    print(regex.matches("15.02.19"))
    println()
    println("qwe".toIntOrNull())

}

fun loops(end: Int){
    for(i in 1..end){
        print(i)
    }
    println()
    for(i in 1 until end){
        print(i)
    }
    println()
    for(i in end downTo 1 step 3) {
        print(i)
    }
    println()
    for (ch in "abc") {
        print(ch + 1)
    }
}

fun getSound(): String =
    when (val pet = getPet()) {
        is Cat -> pet.meow()
        is Dog -> pet.woof()
        else -> ""
    }

fun getPet(): Pet {
    val r = Random.nextInt(100)
    println(r)
    return if (r % 2 == 0) {
        Cat("cat")
    } else {
        Dog("dog")
    }
}

fun sum(first: Int, second: Int): Int {
    return first + second
}

fun sum3(first: Int, second: Int) {
    println("sum of first $first and second $second is ${first + second}")
}

fun updateWeather(degrees: Int) = when {
//        degrees < 10 -> Pair("cold", Color.BLUE)
//        degrees < 25 -> Pair("mild", Color.ORANGE)
//        else -> Pair("hot", Color.RED)

    degrees < 10 -> "cold" to BLUE
    degrees < 25 -> "mild" to ORANGE
    else -> "hot" to RED
}

fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)) {
        setOf(RED, YELLOW) -> ORANGE
        setOf(YELLOW, BLUE) -> GREEN
        setOf(BLUE, VIOLET) -> INDIGO
        else -> throw Exception("Dirty color")
    }

fun displaySeparator(char: Char = '*', size: Int = 10) {
    repeat(size) {
        print(char)
    }
    println()
}